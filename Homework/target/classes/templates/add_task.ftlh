<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
    <link rel="stylesheet" href="css/to_do_list.css">
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
    <hr style="margin: 0; border-width: 5px; margin-bottom: 10px">
    <div class="container">
        <h2 class="main_title partition_title" style="text-align: center; margin-bottom: 10px">
            Новая задача
        </h2>
        <form action="/add_task" method="post">
            <fieldset>
                <div class="form-element">
                    <label for="id">Название задачи: </label>
                    <input type="text" style="margin: 10px 0; padding: 6px 0" name="title" id="id" placeholder="введите название" required autofocus>
                </div>
                <div class="form-element">
                    <label for="id">Исполнитель задачи: </label>
                    <input type="text" style="margin: 10px 0; padding: 6px 0" name="executor" id="id" placeholder="имя исполнителя" required autofocus>
                </div>
                <div class="form-element">
                    Приоритет:
                    <label for="id">
                    <select name="priority">
                        <#list priority as pr>
                            <option style="margin: 10px 0; padding: 6px 0" value="${pr}">${pr.call}</option>
                        </#list>
                    </select>
                    </label>
                </div>

                <div class="form-element">
                    <label for="id">Описание задачи: </label>
                    <input style="margin: 10px 0; padding: 6px 0" type="text" name="description" placeholder="подробное описание" required>
                </div>
                <div class="form-element">
                    <fieldset>
                        <button type="submit" class="new-product-button">Добавить задачу</button>
                    </fieldset>
                </div>
            </fieldset>
        </form>
    </div>
</header>
</body>
</html>

