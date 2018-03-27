-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.14-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.3.0.5107
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных test_base
CREATE DATABASE IF NOT EXISTS `test_base` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test_base`;

-- Дамп структуры для таблица test_base.faculties
CREATE TABLE IF NOT EXISTS `faculties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы test_base.faculties: ~1 rows (приблизительно)
/*!40000 ALTER TABLE `faculties` DISABLE KEYS */;
INSERT INTO `faculties` (`id`, `name`) VALUES
	(1, 'KSIS\r\n');
/*!40000 ALTER TABLE `faculties` ENABLE KEYS */;

-- Дамп структуры для таблица test_base.specialities
CREATE TABLE IF NOT EXISTS `specialities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `faculty_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `faculty_id` (`faculty_id`),
  CONSTRAINT `faculty_id` FOREIGN KEY (`faculty_id`) REFERENCES `faculties` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы test_base.specialities: ~1 rows (приблизительно)
/*!40000 ALTER TABLE `specialities` DISABLE KEYS */;
INSERT INTO `specialities` (`id`, `name`, `faculty_id`) VALUES
	(1, 'ESB', 1);
/*!40000 ALTER TABLE `specialities` ENABLE KEYS */;

-- Дамп структуры для таблица test_base.students
CREATE TABLE IF NOT EXISTS `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group` varchar(50) NOT NULL DEFAULT '0',
  `speciality_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `speciality_id` (`speciality_id`),
  CONSTRAINT `speciality_id` FOREIGN KEY (`speciality_id`) REFERENCES `specialities` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы test_base.students: ~1 rows (приблизительно)
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` (`id`, `group`, `speciality_id`) VALUES
	(1, '113201', 1);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;

-- Дамп структуры для таблица test_base.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` enum('student','head','admin') COLLATE ascii_bin NOT NULL DEFAULT 'student',
  `firstname` varchar(50) COLLATE ascii_bin DEFAULT NULL,
  `lastname` varchar(50) COLLATE ascii_bin DEFAULT NULL,
  `email` varchar(50) COLLATE ascii_bin DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8 NOT NULL,
  `password` varchar(50) COLLATE ascii_bin NOT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stud_id` (`student_id`),
  CONSTRAINT `stud_id` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- Дамп данных таблицы test_base.users: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `role`, `firstname`, `lastname`, `email`, `username`, `password`, `student_id`) VALUES
	(5, 'admin', NULL, NULL, NULL, 'admin', '21232f297a57a5a743894a0e4a801fc3', NULL),
	(6, 'student', 'Divanov', 'Aleksey', 'test@mail.ru', 'student', 'cd73502828457d15655bbd7a63fb0bc8', 1),
	(11, 'student', NULL, NULL, 'test@mail.ru', 'hello', 'ddd', 1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
