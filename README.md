#上传项目步骤

Web端：

1、新建仓库Repository

客户端：

1、初始化
git init

2、将改动添加到暂存区
git add . 或者git add ./xx.jsp

3、提交
git commit -m "提交说明"

4、添加远程地址
git remote add origin https://github.com/yourNmae/yourRepo.git

5、将本地更改推送到远程master分支
git push -u origin master