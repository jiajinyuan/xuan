#!/bin/bash

# 应用路径
APP_HOME=$(cd $(dirname $0);pwd)

# 应用名称
APP_NAME=xuan

#jar包的名字
JAR_NAME="xuan-0.0.1-SNAPSHOT.jar"

check(){
  if [[ -n "${APP_NAME}" ]]
  then
    P_ID=$(ps -ef | grep ${APP_NAME} | grep -v grep | grep -v $0 | awk '{print $2}')
    if [[ -n "${P_ID}" ]]
    then
      return 0
    else
      return 1
    fi
  else
    usage
  fi
}

# 正常提示
function info() {
    local GREEN CLEAN
    GREEN='\033[0;32m'
    CLEAN='\033[0m'
    printf "\n${GREEN}$@  ${CLEAN}\n\n" >&2
}
JAVA_OPTS="-Xms1024M -Xmx24576M -XX:PermSize=1024M -XX:+UseConcMarkSweepGC"


# 警告提示
function warn() {
    local YELLOW CLEAN
    YELLOW='\033[0;33m'
    CLEAN='\033[0m'
    printf "\n${YELLOW}$@  ${CLEAN}\n\n" >&2
}


# 定义启动程序函数
start(){
  check
  if [[ $? -eq "1" ]]; then
    exec -a ${APP_NAME} java ${JAVA_OPTS} -jar ${APP_HOME}/lib/${JAR_NAME} --spring.config.location=${APP_HOME}/config/application.properties --logging.config=${APP_HOME}/config/logback-spring.xml >/dev/null 2>&1 &
    info "当前路径：${APP_HOME}"
    info "启动参数：${JAVA_OPTS}"
    info "应用名称：${APP_NAME}"
    info "应用程序：${JAR_NAME}"
    info "【SUCCESS】应用程序【${APP_NAME}】启动成功, 进程号为：$!"
  else
    warn "【启动失败】"
    warn "【WARN】应用程序【${APP_NAME}】已在运行中，进程号为：${P_ID}，请更换名称后重试！！！"
    ps -ef | grep ${APP_NAME} | grep -v grep | grep -v run.sh
    printf "\n" >&2
  fi
}

# 停止进程函数
stop(){
  check
  if [[ $? -eq "0" ]]; then
    kill -9 ${P_ID}
    info "应用程序【${APP_NAME}】已被成功终止服务"
  else
    info "应用程序【${APP_NAME}】并未启动"
  fi
}
# 查看进程状态
status(){
    check
    if [[ $? -eq "0" ]]; then
      info "应用程序【${APP_NAME}】运行中, 进程号为：${P_ID}"
      ps -ef | grep ${APP_NAME} | grep -v grep | grep -v run.sh
      printf "\n" >&2
    else
      info "应用程序【${APP_NAME}】未启动"
    fi
}


# 重启进程函数
restart(){
  stop
  start
}


function main(){
    case $1 in
      "start")
        start
        ;;
      "stop")
        stop
        ;;
      "restart")
        restart
        ;;
      "status")
        status
        ;;
      *)
        usage
        ;;
    esac
    exit 0
}
main $@




