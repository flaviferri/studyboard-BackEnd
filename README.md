
# StudyBoard ✏️ 📚

## Índice

- [Proyecto 📝](#proyecto-)
    - [Diseño](#diseño-)
- [Diagramas](#diagrama-)
    - [Diagrama de flujo](#diagrama-de-flujo-)
    - [Diagrama de datos](#diagrama-de-datos-)
- [Instalación 🛠️](#installation-)
    - [Requerimientos](#requerimientos-)
- [Estructura del proyecto](#estructura-del-proyecto-)
- [Tecnologías](#tecnologias-)
- [Uso](#uso-)
- [Contribución 🤝](#contribution-)
- [Coders👩‍💻](#coders-)
- [Demo](#demo-)


## Proyecto 

Study Board permite a los usuarios crear grupos de estudio donde pueden compartir y organizar sus ideas utilizando post-its. Cada post-it puede contener texto, fragmentos de código o puntos clave para la discusión del grupo. Además, la aplicación está integrada con un calendario, lo que ayuda a los usuarios a fijar fechas importantes y mantenerse organizados con sus tareas. Esto convierte a Study Board en una herramienta invaluable tanto para estudiantes como para profesionales que buscan una forma eficiente de colaborar y gestionar sus tiempos de estudio.

Nació de la visión de nuestro cliente, Alejandro Arends, quien identificó la necesidad de una plataforma interactiva que haga del estudio una experiencia más colaborativa y organizada.

Este proyecto refleja nuestro compromiso con el uso de la tecnología para resolver problemas reales. Creemos que Study Board fomentará mejores experiencias de aprendizaje, apoyará la colaboración entre usuarios, ayudándoles en sus estudios a través de la organización conjunta.

Es un proyecto full-stack, [aquí está el repositorio del front](https://github.com/Euge-Saravia/studyBoard-frontend), desarrollado en un período de 3 semanas como proyecto final pedagógico del bootcamp FemCoders (P5). 


### Diseño

El diseño de la interfaz fue generado en un primer momento en Figma, donde se delimitaron en primera instancia los elementos más atómicos, para ir construyendo componente a componente el diseño completo de la aplicación.

Se ha diseñado mobile-first, con diseño responsive en dos puntos de quiebre: tablet y desktop.

![Captura de pantalla 2024-10-08 165606](https://github.com/user-attachments/assets/5e836870-880b-4f8c-98fa-6015ed39ce85)

[Figma: diseño completo](https://www.figma.com/design/oNZF199M4XEQXb1X6M3142/StudyBoard?node-id=57-239&node-type=canvas&t=XIAw5AUvCqypxScB-0)

## Diagramas

Se han trabajado diferentes diagramas, tanto de usuario como de flujo, para poder comprender y acotar la experiencia de usuario y la funcionalidad de la página. Así, se ha facilitado el desarrollo y diseño de lógica e interfaz.

### Diagrama de flujo

[Ver diagrama de flujo](https://www.figma.com/board/qTEY5ot9JEudIyxylV8HaX/StudyGroup?node-id=0-1&node-type=canvas&t=2S1iDzWeHtOCqMER-0)

### Diagrama de flujo usuario

[Ver diagrama de flujo de usuario](https://www.figma.com/board/0QeyPkuYDwmtZII23A7JVr/StudyBoard?node-id=0-1&t=DuS9l8A4MwcQ2sI0-1)

### Diagrama de datos

La aplicación de StudyBoard implementa diferentes roles que, a su vez, tienen distintos permisos. Esto ha resultado en una aplicación de alta complejidad en las relaciones entre entidades. Para poder visualizar y comprender dichas relaciones se ha creado un diagrama de datos que puede verse a continuación. 

[Ver diagrama de datos](https://dbdiagram.io/d/StudyBoard-66fd5e31fb079c7ebd1bc8f1)



## Instalación 🛠️

### Requerimientos

- [Node.js](https://nodejs.org/en)
- [VSC](https://www.w3schools.com/java/java_intro.asp) con [extensión Java Pack VSC](vscjava.vscode-java-pack), [IntelliJ](https://www.jetbrains.com/es-es/idea/)  or tu IDE de preferencia
- Base de datos


1. Clona los repositorios:
```bash
Front:
 git clone https://github.com/Euge-Saravia/studyBoard-frontend

Back:
 git clone https://github.com/flaviferri/studyBoard-BackEnd

```

2. Haz npm install en el repo del front

3. Crea tu base de datos (en este caso se ha usado PostgreSQL) y conectála al repo del back:

En application.properties:
```
Añade el link de acceso, tu usuario y contraseña de pgAdmin o de tu base de datos
```
```
En el caso de que estes usando otra BBDD, instala las dependencias respectivas en el documento pom.xml
```
Para el registro y login con Github:
```
Incluye en application.properties tu CLIENT_ID y CLIENT_SECRET de Github
```
https://docs.github.com/en/apps/oauth-apps/building-oauth-apps/creating-an-oauth-app



En values.properties:
```
incluye tu secret key en BASE64 para encripción de token
```



## Estructura del proyecto

Como proyecto de desarrollo Full-Stack, se divide en Front y en Back, resultando en dos estrcuturas distintivas que pueden verse en los respectivos README. 

El back del proyecto se ha desarrollado en SpringBoot, centrándose en una arquitectura de MVC de tres capas. 

La estructura actual del back es la siguiente:


```plaintext
/
├── STUDYBOARD-BACKEND
│   ├── src/main/java
│   │    ├── config
│   │    │     ├── jwt
│   │    │     │    ├── JwtAuthenticationFilter
│   │    │     │    └── JwtService
│   │    │     ├── AppConfig
│   │    │     └── SecurityConfig
│   │    ├── controller
│   │    │     ├── AuthController
│   │    │     ├── AuthResponse
│   │    │     ├── BoardController
│   │    │     ├── GroupController
│   │    │     ├── LoginController
│   │    │     ├── PostItController
│   │    │     └── UseController
│   │    ├── dto
│   │    │     ├── AuthRequest
│   │    │     ├── BoardDTO
│   │    │     ├── CreatedByDTO
│   │    │     ├── GroupDTO
│   │    │     ├── PostitDTO
│   │    │     └── RegisterRequest
│   │    ├── exceptions
│   │    │      ├── BoardNotFoundException
│   │    │      ├── EmailExistsException
│   │    │      ├── ErrorObject
│   │    │      ├── GlobalExceptionHandler
│   │    │      ├── GroupHasNoBoards
│   │    │      ├── GroupNotFoundException
│   │    │      └── NoPostItsOnSelectedDate
│   │    ├── model
│   │    │      ├── BaseEntity
│   │    │      ├── Board
│   │    │      ├── Group
│   │    │      ├── PermissionEntity
│   │    │      ├── Postit
│   │    │      ├── RoleEntity
│   │    │      ├── RoleEnum
│   │    │      ├── UserEntity
│   │    │      └── UserGroupRole
│   │    ├── repository
│   │    │      ├── BoardRepository
│   │    │      ├── GroupRepository
│   │    │      ├── PermissionRepository
│   │    │      ├── PostItRepository
│   │    │      ├── RoleRepository
│   │    │      ├── UserGroupRoleRepository
│   │    │      └── UserRepository
│   │    ├── service
│   │    │      ├── AuthService
│   │    │      ├── BoardService
│   │    │      ├── CustomUserDetailsService
│   │    │      ├── GroupService
│   │    │      ├── IBoardService
│   │    │      ├── IGroupService
│   │    │      ├── IPostitService
│   │    │      ├── IUserService
│   │    │      ├── PostItService
│   │    │      ├── RoleService
│   │    │      ├── SetupDataLoader
│   │    │      ├── UserGroupRoleSerivce
│   │    │      └── UserService
│   │    ├── StudyBoardBackendApplication
│   │    ├── resources
│   │    │    ├── application.properties
│   │    │    └── values.properties
│   │    └── test
│   ├── target
│   ├── .env
│   ├── .gitignore
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
└── └── README.md

```


## Tecnologías

**Back:** 
- [Java](https://www.java.com)
- [PgAdmin](https://www.pgadmin.org/)+ [SQL](https://www.w3schools.com/sql/default.asp)
- [SpringBoot](https://spring.io/projects/spring-boot)

**Front:** 
- [React.js](https://react.dev/)
- [JavaScript](https://www.w3schools.com/js/js_intro.asp)
- [SASS](https://sass-lang.com/)


## Uso
El programa debe iniciarse primero en el back.

Para compilar:

```
Compila la aplicación.
```

Una vez iniciado el back, en el front:

```
npm run dev
```

Abre el enlace que aparece con tu puerto local. 


## Contribución 🤝

1. Haz un fork al repositorio.
2. Crea una nueva rama: `git checkout -b feature/name`.
3. Haz tus cambios.
4. Haz push de tu rama: `git push origin feature/name`.
5. Crea un pull request.


 ## Coders👩‍💻
Este proyecto ha sido desarrollado por una única coder: 

- [Isabel Afonso](https://github.com/IsaLagu)
- [Flavia Ferrigno](https://github.com/flaviferri/)
- [Rebeca García](https://github.com/rebkg87)
- [Laura Gil](https://github.com/LauraGDev)
- [Betty Lopez](https://github.com/BettyLopo)
- [Eugenia Saravia](https://github.com/Euge-Saravia/)

## Demo
<img width="859" alt="login_sb" src="https://github.com/user-attachments/assets/f7eac57e-fe18-414b-9942-508e39e83afc">
<img width="865" alt="home_sb" src="https://github.com/user-attachments/assets/e57e04ef-f40a-4797-a835-6d1d9f4d3d53">
<img width="864" alt="search_sb" src="https://github.com/user-attachments/assets/c8a2a11f-1388-44bf-b91f-97f4652a4ae1">
<img width="864" alt="creargrupo_sb" src="https://github.com/user-attachments/assets/3b6e1bb3-0de2-4cc9-b481-6c9cf5592f1e">
<img width="865" alt="aboutus_Sb" src="https://github.com/user-attachments/assets/6900403a-d8ea-4ace-ad40-d55f3a85f9fe">
<img width="866" alt="userdesktop_sb" src="https://github.com/user-attachments/assets/d4382ec5-2530-484b-b06a-494d90a7d59d">
<img width="863" alt="group_sb" src="https://github.com/user-attachments/assets/73c1fbb2-ffd1-4e1e-9adf-b18c1d2e523e">
https://github.com/user-attachments/assets/6452e35c-9d80-46ac-855f-92b8cff8ae24
<img width="867" alt="createdboard_sb" src="https://github.com/user-attachments/assets/78a1a917-3264-4d8c-ac16-7cded5c16686">
<img width="867" alt="crearboard_sb" src="https://github.com/user-attachments/assets/804a26d3-66e1-4581-978f-9d99518853f9">
<img width="869" alt="postitinicial_sb" src="https://github.com/user-attachments/assets/6eeaacbd-cd48-41a5-8b97-352a65cf0a76">
<img width="310" alt="mobile1_sb" src="https://github.com/user-attachments/assets/3123c3c3-bcfb-421c-bff0-f794484e134b">
<br>
<img width="312" alt="mobile2_sb" src="https://github.com/user-attachments/assets/be7b6c85-5324-4a51-8021-71f4ed25856b">
<br>
<img width="308" alt="mobile3_sb" src="https://github.com/user-attachments/assets/664bddcb-1000-446d-bc7c-d6e1c47e0d1e">
<br>
<img width="308" alt="mobile4_Sb" src="https://github.com/user-attachments/assets/29eb136b-89fa-403e-a75b-9bc56174d4f7">
<br>
<img width="306" alt="mobile5_sb" src="https://github.com/user-attachments/assets/716c9cb7-efed-4173-aecb-0d28be76a384">
<br>
https://github.com/user-attachments/assets/a61083b5-539d-414e-9386-bd50fb407d7d
