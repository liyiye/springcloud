#ngtms部署到K8s的配置文件
#### 1. yaml文件
1. svservice 暴露8081的服务给到web进行调用，web的接口需要定义为：http://SVSERVICE:8081/intf
2. webservice 通过NodePor暴露30001的端口给到集群外进行访问

#### 2. 镜像文件
1. Dockerfile 为基础镜像，通过该文件生成基础的配置文件
2. 通过gradle脚本分别createDockerfile(生成镜像文件)，buildImage(编译镜像)，pushImage(发布镜像)
