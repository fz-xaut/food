<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <link rel="stylesheet" type="text/css" href="<%=basePath%>css2/demo.css" />
        <link rel="stylesheet" type="text/css" href="<%=basePath%>css2/style.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css2/animate-custom.css" />
    </head>
    <body>
        <div class="container">
        	<br/><br/><br/>
            <header>
                <h1><span>XAUT食堂点餐系统</span></h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="verify.action" method="post" autocomplete="on"> 
                                <h1>登录</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > 用户名 </label>
                                    <input id="username" name="stuName" required="required" type="text" placeholder="name"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> 密码 </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="password" /> 
                                </p>
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">记住我</label>
								</p>
                                <p class="login button"> 
                                    <input type="submit" value="立即登录" /> 
								</p>
                                <p class="change_link">
									还没注册？ 
									<a href="#toregister" class="to_register">注册</a>
								</p>
                            </form>
                        </div>

                        <div id="register" class="animate form">
                            <form  action="sign.action" method="post" autocomplete="on"> 
                                <h1>注册</h1> 
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">用户名</label>
                                    <input id="usernamesignup" name="stuName" required="required" type="text" placeholder="name" />
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">学号</label>
                                    <input id="usernamesignup1" name="stuNo" required="required" type="text" placeholder="stuID" />
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">电话</label>
                                    <input id="usernamesignup2" name="stuCall" required="required" type="text" placeholder="call" />
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">地址</label>
                                    <input id="usernamesignup3" name="stuAddress" required="required" type="text" placeholder="address" />
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">密码</label>
                                    <input id="passwordsignup" name="password" required="required" type="password" placeholder="password"/>
                                </p>
                                <p class="signin button"> 
									<input type="submit" value="立即注册"/> 
								</p>
                                <p class="change_link">  
									已经注册 ?
									<a href="#tologin" class="to_register">去登录</a>
								</p>
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>