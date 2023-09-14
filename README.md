# GainGround

 ## <span style="color:green">Project progress status - 55%</span>

## About App
The Gain Ground platform provides employers with a talent base for many years to come, and for talented, outstanding teenagers and students to get promising jobs that they have long dreamed of. Since the school exam system is not perfect and many cannot pass it with a high score, due to some reasons (for example, poor preparation at school, anxiety, unequal USE options and banal inattention), Gain Ground provides an alternative opportunity to realize oneself and demonstrate one's true potential. My platform is not an ordinary job search site, it is based on project and olympiad activities and a bonus system. This platform is a kind of symbiosis of a job search site and a project repository.

On this slide you can see the main page of the platform (for an employee), it displays all the news, updates and events of the Gain Ground company.
<img width="610" alt="image" src="https://github.com/DeeMMoon/GainGroung/assets/37477667/ec35fdc5-fe7a-44c3-ae53-c6914f7944f8">

## Roles
Our platform provides 3 access roles. The roles of the employer, employee and moderator (for employees of the company). In order to go to the main page and subsequent services of the platform, you need to pass authorization on the site, and before that, registration, where the user can select a role (either an employee or an employer). After successful authorization, the user has access to certain application functionality, its set depends on what role the user has chosen.

The following functions are available for the employee:
  - Create, delete, edit and view achievements and projects
  - Messenger with employer
  - Participant rating
  - Profile and editing
  - Information about employers

Employers have access to the following features:
  - Messenger with employees
  - Rating and profiles of participants
  - Profile and its editing

The role of the moderator is closed and inaccessible to ordinary users, the login and password are initially set in the database. Moderators have access to the data of other users, they can see their names, rating points, logins and passwords (but the passwords are encrypted, so the privacy of users is preserved), as well as delete users. Also, moderators check achievements and projects for authenticity and have access to services statistics and advertising.
<img width="609" alt="image" src="https://github.com/DeeMMoon/GainGroung/assets/37477667/56649675-738d-44fd-b44c-de8a6a0df4da">

## Bonus system
Bonuses of the "Gain Ground", "leaf" system that users receive for being active on the site and participating in events such as olympiads, hackathons, case championships, etc. Leafs raise them in the overall ranking, which allows them to make themselves known to the whole world and to interest a large number of employers.

## How to use
1) Download git repository
2) Connect the desired database in the properties file
3) Launch the application
4) Run SQL script
5*) Add a user who will be a moderator (or create a regular user and then change his role to ROLE_ADMIN in the user_role table)
