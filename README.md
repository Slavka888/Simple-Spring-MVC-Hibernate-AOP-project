# Simple Spring MVC + Hibernate + AOP Project

Простой шаблонный проект на Java с использованием Spring MVC, Hibernate и AOP. Подходит как стартовая точка для учебных проектов и небольших приложений.

## Короткое описание
Проект демонстрирует базовую интеграцию:
- Spring MVC для слоя веб-контроллеров
- Hibernate (JPA) для работы с базой данных
- AOP (Aspect-Oriented Programming) для кросс-секционных задач (логирование, транзакции и т.п.)

## Требования
- JDK 8 или выше
- Maven (или Gradle, если проект настроен под него)
- СУБД: H2 / MySQL / PostgreSQL (настроить в application.properties / persistence.xml)

## Быстрый старт
1. Клонируйте репозиторий:
   git clone https://github.com/Slavka888/Simple-Spring-MVC-Hibernate-AOP-project.git

2. Настройте параметры подключения к базе данных в src/main/resources (application.properties или persistence.xml).

3. Соберите проект:
   mvn clean package

4. Запустите приложение:
    - Если это Spring Boot-приложение:
      mvn spring-boot:run
      или
      java -jar target/your-artifact.jar
    - Если это стандартное web-приложение — разверните WAR в контейнере (Tomcat).

## Основные возможности
- Пример контроллера MVC
- Конфигурация Hibernate/JPA для простых CRUD-операций
- Простая AOP-конфигурация (логирование вызовов методов)
- Пример DAO/Service/Controller слоёв

## Структура проекта
- src/main/java — исходный код
- src/main/resources — конфигурационные файлы (properties, xml)
- src/main/webapp — веб-ресурсы
- pom.xml — Maven-конфигурация (или build.gradle)
