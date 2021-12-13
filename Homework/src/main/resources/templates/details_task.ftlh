<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
    <link rel="stylesheet" href="../static/css/to_do_list.css">
</head>
<body>
<header>
    <div class="header_box">
        <div class="container">
            <div class="header_flex_container">
                <div class="header_flex">
                    <a href="/"><img src="/images/logo.png" alt="logo" style="display:block; width: 50px; height: 40px;></a>
                    <nav class="nav header_nav">
                        <a href="/" class="nav_link"> Все задачи</a>
                        <a href="/add_task" class="nav_link"> Добавить задачу</a>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <h2 class="main_title partition_title">
            Новая задача
        </h2>
       Задача ${task.status}
        <hr>
       Статус ${task.status}
        <hr>
       Приоритет ${task.priority}
        <hr>
        Исполнитель задачи ${task.executor}
        <hr>
       Номер ${task.id}


        Описание:${task.description}
        <div class="column">
            <#if task.status=="Закрытая">
                <p>Дата закрытия: ${task.closeData}</p>
                <form action="/task/${task.id}/remove" method="post">
                    <button type="submit" class="join">удалить</button>
                </form>
            <#elseif task.status=="Новая">
                <form action="/task/${task.id}/remove" method="post">
                    <button type="submit" class="join">удалить</button>
                </form>
            <form action="/task/${task.id}/open" method="post">
                 <button type="submit" class="join">открыть</button>
            </form>

            <#else >
                <form action="/task/${task.id}/close" method="post">
                    <button type="submit" class="join">закрыть</button>
                </form>
                <p>Дата создания: ${task.creationDate}</p>
            </#if>


<#--            <#if task.status=="Oткрыта">-->
<#--                <form action="/task/${task.id}/close" method="post">-->
<#--                    <button type="submit" class="join">закрыть</button>-->
<#--                </form>-->
<#--            <#elseif task.status=="Закрыта"&&task.status.name=="Новая">-->
<#--                <form action="/task/${task.id}/remove" method="post">-->
<#--                    <button type="submit" class="join">удалить</button>-->
<#--                </form>-->
<#--            <#elseif task.status=="Новая">-->
<#--                <form action="/task/${task.id}/open" method="post">-->
<#--                    <button type="submit" class="join">открыть</button>-->
<#--                </form>-->
<#--            </#if>-->
        </div>
    </div>
</header>
</body>
</html>

