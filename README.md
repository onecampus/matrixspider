## Wechat matrix spider

#### dependencies

1. [gradle](http://www.gradle.org/)
2. [jsoup](http://jsoup.org/)
3. [junit](http://junit.org/)
4. [log4j](http://logging.apache.org/log4j/2.x/index.html)

### github workflow

```bash
git clone git@github.com:onecampus/matrixspider.git
git branch -r
git checkout -b dev origin/dev # 检出 dev 分支, 并对应到本地的dev分支
git checkout -b your_name dev # 创建自己的私有分支, start_point 为dev
# 做修改, 提交, 注意不要推送到远程
git checkout dev # 切换到 dev 分支
git pull # 拉取远程更新
# 如果拉取遇到问题, 可能需要 git branch --set-upstream-to=origin/dev dev
git merge --no-ff your_name # 合并 your_name 到当前分支, 这里是 dev, 必须使用 --no-ff
git branch -d your_name # 删除 your_name 本地分支
git push origin dev # 推送 dev 分支到远程
```

#### eclipse
Maybe you need install gradle plugin for eclipse. [Gradle Tooling](https://github.com/spring-projects/eclipse-integration-gradle#installing-gradle-tooling-from-update-site)

```ruby
gradle cleanEclipse
gradle eclipse
```

#### idea

```ruby
gradle cleanIdea
gradle idea
```

#### Usage

```ruby
gradle build
java -jar build/libs/matrixspider-0.1.0.jar
```

### Test

```ruby
# Use gradle test to test it
gradle test
```
