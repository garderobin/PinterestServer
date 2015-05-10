<h1>开发日志</h1>
<p>LP: 2015-04-24 5:11 pm
repin这个属性的用法必须改。否则无法统计转发数量。
</p>
<p>LP: 2015-04-24 03:00
提醒：把WebRoot/WEB-INF/classes/com/bean下面的内容全部删光。我们的项目跑不起来org.hibernate.MappingException: entity class not found 是因为这个目录下面的历史文件大小写与我们现在的版本不匹配（comment和likes),我们改成大写以后只会生成Comment.class和Likes.class而不会覆盖comment.class和likes.class，而hibernate不识别大小写。切记class文件全都不必保存。
</p>
<p>页面间简单传值已经实现。下一步要做Ajax.</p>
<p>LP: 2015-04-18 11:41 pm</p>
<p>已完成：登录功能。框架已能正常使用。<br/>
测试方法：先在本地数据库中user表里插入一条数据，在主界面登录以后能看到This is my JSP page.<br/>
可能的问题：我们的用户暂时不区分普通用户和管理员用户。<br/></p>
<p>部分完成：好友添加，好友删除的service层代码。<br/>
新增加的util包是用来存放一些辅助代码，比如我们自己定义的一些常量，或者导入的第三方插件的代码等。</p>
<p>下一步我的计划：1登出、2注册、3好友添加、4好友删除功能的后台部分（Service, Util）<br/>
希望韬哥优先实现的相关接口：UserDAOImpl.java中标注为TODO的方法。<br/>
接口说明在UserDAO.java的注释里。蓝字是接口定义，不要改。绿字是咱们自己沟通用的提示、交流。<br/>
辛苦啦^_^</p>


