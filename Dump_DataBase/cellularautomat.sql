-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 30 Mars 2017 à 00:16
-- Version du serveur :  5.6.22-log
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `cellularautomat`
--

-- --------------------------------------------------------

--
-- Structure de la table `contributor`
--

CREATE TABLE IF NOT EXISTS `contributor` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Id of contributor',
  `Name` varchar(30) NOT NULL COMMENT 'Name of contributor',
  `FirstName` varchar(30) NOT NULL COMMENT 'First name of contributor',
  PRIMARY KEY (`id`),
  KEY `Name` (`Name`,`FirstName`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='Contributors for the application' AUTO_INCREMENT=2 ;

--
-- Contenu de la table `contributor`
--

INSERT INTO `contributor` (`id`, `Name`, `FirstName`) VALUES
(1, 'AUDA', 'Alexandre');

-- --------------------------------------------------------

--
-- Structure de la table `logs`
--

CREATE TABLE IF NOT EXISTS `logs` (
  `EVENT_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `EVENT_DATE` datetime NOT NULL,
  `LEVEL` varchar(50) NOT NULL,
  `LOGGER` varchar(50) NOT NULL,
  `MESSAGE` text NOT NULL,
  PRIMARY KEY (`EVENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
