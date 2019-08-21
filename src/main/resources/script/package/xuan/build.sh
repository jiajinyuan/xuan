#!/bin/bash

#错误退出
set -e
#变量未初始化使用时退出
#set -u

if [ $# -eq 2 ];then
   PROJECT_VERSION=$1
   CURRENT_TIME=$2
else
   echo -n "1.请输入待编译版本号, 默认回车为V305R001C08版本:"
   read PROJECT_VERSION
   if [ -z "$PROJECT_VERSION" ];then
      PROJECT_VERSION="V305R001C08"
   fi

   CURRENT_TIME=`date -d now +%Y%m%d%H%M%S` # 打包目录，根据当前时间生成
fi

BASE_PATH=$(cd `dirname $0`; pwd)
PROJECT_NAME="xuan"
PKG_NAME="XUAN_${PROJECT_VERSION}_${CURRENT_TIME}_INSTALL.tar.gz"
PKG_PATH=$BASE_PATH/package
app_package_name=xuan-0.0.1-SNAPSHOT.jar

SERVER_SOURCE_CODE_PATH=$BASE_PATH/source_code/$PROJECT_NAME
SERVER_SVN_PATH="svn://10.0.5.11/project/"$PROJECT_VERSION"/"$PROJECT_NAME
SVN_USER="yangyao"
SVN_PASSWORD="15982461152"

function updateSourceCode {
	#更新后端代码
	if [ -d $SERVER_SOURCE_CODE_PATH ]; then
		rm -rf $SERVER_SOURCE_CODE_PATH
	fi
	svn checkout $SERVER_SVN_PATH $SERVER_SOURCE_CODE_PATH --username $SVN_USER --password $SVN_PASSWORD
}	

function build {
	#从SVN更新源码
	updateSourceCode
	#后端打包
	cd $SERVER_SOURCE_CODE_PATH
	
	\mv ${BASE_PATH}/source_code/${PROJECT_NAME}/src/main/resources/application.properties ${BASE_PATH}/package/${PROJECT_NAME}/config/
  \mv ${BASE_PATH}/source_code/${PROJECT_NAME}/src/main/resources/logback-spring.xml ${BASE_PATH}/package/${PROJECT_NAME}/config/

	mvn clean package -DskipTests
	cp ${BASE_PATH}/source_code/${PROJECT_NAME}/target/${app_package_name} ${BASE_PATH}/package/${PROJECT_NAME}/lib/

  cd ${BASE_PATH}/package
  tar -zcvf ${PKG_NAME} ${PROJECT_NAME} --exclude=*.svn
}

build | tee ./log/build.log
