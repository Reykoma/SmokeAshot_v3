Технологии: Java, Selenium, ashot tools, testNG, maven, jenkins

Что делает проргамма?
Создает и сравнивает скриншоты элементов сайта с ПРОДА и СТЕЙДЖА. То есть проверяет элементы верстки на отображение.

Тесты:
https://github.com/Reykoma/SmokeAshot_v3/blob/master/src/test/java/MainTests.java
В теле теста указывается урл и селектор элемента что нужно скриншотить и передаются в метод создания скриншотов.

Методы создания скриншотов:
https://github.com/Reykoma/SmokeAshot_v3/blob/master/src/ToolsAshot/SA.java

Непосредственно низкоуровневый код выполняющий всю работу для создания сохранения сравнения и прочего здесь:
https://github.com/Reykoma/SmokeAshot_v3/blob/master/src/ToolsAshot/SAtools.java

