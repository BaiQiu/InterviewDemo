# 项目计划

## 需求
我们已经到了最后一个学期，即将面临就业，所以需要熟悉各种面试的问题，而不断累积面试题目的知识显然是一个明智之举。然而每次在进行练习时去手动复印面试题，然后老师进行手动评分，统计分数，这些操作都是复杂而重复的。因此我们想要开发这个面试题考试平台，简化考试，评分，记录和查看的流程，以此提高考试的效率。

## 实现的功能
### 前台
- 首页
- 学生登陆/注册
- 进行考试
- 查询成绩
- 查询考试详情
- 查询所有面试题目
- 评论面试题目

### 后台
- 首页
- 管理员登陆
- 查询所有学生信息
- 查询/添加/修改/删除面试题目
- 查询学生成绩趋势
- 查询学生考试详情
- 查询学生成绩
- 添加考试

## 数据库
- user_login: 用户登录信息
- user_info: 用户详细信息
- topic_type: 面试题目类型
- topic: 面试题目
- examination: 考试信息表
- result: 考试成绩表
- comment: 题目评论表
- admin: 管理员表

## 遇到的问题
1. 数据库远程连接失败
	将数据库连接的 `url=jdbc:mysql://192.168.2.70:3306/interview_demo?useUnicode=true&characterEncoding=UTF-8&useSSL=false` 修改为 
`url=jdbc:mysql://192.168.2.70:3306/interview_demo?useUnicode=true&characterEncoding=UTF-8&useSSL=true`，以使在 windows 平台可以免密连接.
2. git 无法推动到自己 fork 的分支里面
3. css 样式或引用外部图片无法生效
	此问题一般发生于使用相对于 webapp 的 web 项目，因为使用了相对于 webapp 的相对路径，所以必须启动服务器才能生效。启动 tomcat 容器之后使用 `localhost:8080/路径` 去访问页面一般即可解决.

## 规范
- 引入外部 js 文件需要放到 html/jsp 文件内容尾部，以确保所有 html 元素加载完成之后再去加载 js 脚本.
- 类的成员变量名采用驼峰命名法，类名采用首字母大写的驼峰命名法，常量则全大写以下划线进行分割.
- Dao 层的类名由实体类名+Mapper 命名，全部放置在 `src/main/java/**/dao/` 包下面，而对应的 mybatis 映射文件则放置在 `src/main/resources/mapper/` 文件夹下，必须要和 Dao 层的数据访问接口一一对应。
- Service 和 Controller 这是根据需求命名，但还是要有后缀 Service 和 Controller，实现类则在接口的基础上再加上 Impl 后缀作为区分，并要在其子包 impl