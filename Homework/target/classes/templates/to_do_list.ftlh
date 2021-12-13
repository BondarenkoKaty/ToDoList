<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
    <link rel="stylesheet" href="css/to_do_list.css">
</head>
<body style="text-decoration-color: bisque">
<header>
    <div class="header_box" style="background-color: lavender; text-decoration-color: bisque">
        <div class="container">
            <div class="header_flex_container">
                <div class="header_flex">
                    <a href="/"> <img src="/images/logo.png" alt="logo" style="display:block; width: 50px; height: 40px;>  </a>
                    <nav class="
                        <nav header_nav>
                        <a href="/" class="nav_link"> Все задачи</a>
                        <a href="/add_task" class="nav_link"> Добавить задачу</a>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <hr style="margin: 0; border-width: 5px; margin-bottom: 10px">
    <div class="container">
        <table border="1">
            <tr>
                <td>Номер</td>
                <td><a href="/sort_task_name?sort=SortByNameAsc">Название задачи</a></td>
                <td><a href="/sort_task_name?sort=SortByPriorityAsc">Приоритет</a></td>
                <td><a href="/sort_task_name?sort=SortByStatusAsc">Статус</a></td>
                <td><a href="/sort_task_name?sort=SortByCreationDateAsc">Дата создания</a></td>
                <td>Действия</td>
            </tr>

            <#list tasks as task>
                <tr>
                    <td>${task.id}</td>
                    <td>${task.title}</td>
                    <td>${task.priority.call}</td>
                    <td>${task.status}</td>
                    <td>${task.creationDate}</td>

                    <td>
                        <div class="column">
                            <a href="task/${task.id}/"><button>детали</button></a>
                            <#if task.status=="Открыта">
                                <form action="/task/${task.id}/close" method="post">
                                    <button type="submit" class="join">закрыть</button>
                                </form>
                            <#elseif task.status=="Новая">
                                <form action="/task/${task.id}/open" method="post">
                                    <button type="submit" class="join">открыть</button>
                                </form>
                                <form action="/task/${task.id}/remove" method="post">
                                    <button type="submit" class="join">удалить</button>
                                </form>
                             <#else >
                               <form action="/task/${task.id}/remove" method="post">
                                    <button type="submit" class="join">удалить</button>
                                </form>
                            </#if>
                        </div>

                    </td>
                </tr>
            </#list>
        </table>
    </div>
</header>
</body>
</html>

