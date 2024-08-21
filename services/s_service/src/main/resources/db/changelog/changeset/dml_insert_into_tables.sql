insert into faculties(name) values('Faculty_1');
insert into faculties(name) values('Faculty_2');

insert into students(name, surname, patronymic, faculty_id) values('Name_1', 'Surname_1', 'Patronymic_1', 2);
insert into students(name, surname, patronymic, faculty_id) values('Name_2', 'Surname_2', 'Patronymic_2', 1);
insert into students(name, surname, patronymic, faculty_id) values('Name_3', 'Surname_3', 'Patronymic_3', 2);
insert into students(name, surname, patronymic, faculty_id) values('Name_4', 'Surname_4', 'Patronymic_4', 1);
insert into students(name, surname, patronymic, faculty_id) values('Name_5', 'Surname_5', 'Patronymic_5', 1);

insert into grade_diaries(number, student_id) values('2024_0002_000001', 1);
insert into grade_diaries(number, student_id) values('2024_0001_000001', 2);
insert into grade_diaries(number, student_id) values('2024_0002_000002', 3);
insert into grade_diaries(number, student_id) values('2024_0001_000002', 4);
insert into grade_diaries(number, student_id) values('2024_0001_000003', 5);