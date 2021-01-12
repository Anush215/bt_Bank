-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 24, 2020 at 08:19 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bt_bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `name` varchar(45) NOT NULL,
  `password` varchar(20) NOT NULL,
  `birth_day` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `nic` varchar(45) NOT NULL,
  `mobile` int(11) NOT NULL,
  `position` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`name`, `password`, `birth_day`, `gender`, `address`, `nic`, `mobile`, `position`) VALUES
('test', 'test', '20.20.2020', 'male', 'colombo 7,\r\nsrilanka.', '123456789V', 123456789, 'manager'),
('kj', 'kj', '02/02/2020', 'male', 'kj', '12345V', 2135, 'Manager'),
('tingo', 'tingo', '1/1/1950', 'female', 'tingo house,colombo 9', '123654', 123654, 'Manager'),
('jecob', 'jecob', '10.02.1236', 'male', 'polonnaruwa', '123654V', 123652, 'Manager'),
('jehan perera', 'jehan', '20.20.20', 'male', 'colombo 7', '20201010V', 32145696, 'Manager');

-- --------------------------------------------------------

--
-- Table structure for table `cashier`
--

CREATE TABLE `cashier` (
  `name` varchar(45) NOT NULL,
  `password` varchar(20) NOT NULL,
  `birth_day` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `nic` varchar(20) NOT NULL,
  `mobile` int(11) NOT NULL,
  `position` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cashier`
--

INSERT INTO `cashier` (`name`, `password`, `birth_day`, `gender`, `address`, `nic`, `mobile`, `position`) VALUES
('hector perera', 'hector', '12.02.1985', 'male', 'pothuhera,kurunegala', '74125896V', 21347854, 'Cashier'),
('tingo', 'tingo', '1/1/1950', 'female', 'tingo house,colombo 9', '123654', 123654, 'Cashier'),
('johan', 'johan', '01/02/1235', 'male', 'johan haouse matara', '98564532V', 21574125, 'Cashier');

-- --------------------------------------------------------

--
-- Table structure for table `customer_acc`
--

CREATE TABLE `customer_acc` (
  `account_no` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `acc_type` varchar(45) NOT NULL,
  `date_of_birth` varchar(45) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `nic` varchar(45) NOT NULL,
  `mobile` int(11) NOT NULL,
  `initial_pay` double NOT NULL,
  `curr_bal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer_acc`
--

INSERT INTO `customer_acc` (`account_no`, `name`, `acc_type`, `date_of_birth`, `gender`, `address`, `nic`, `mobile`, `initial_pay`, `curr_bal`) VALUES
(100001, 'test', 'savings account', '20.12.2020', 'male', 'test1,\r\ntest2,\r\ntest3.', '111111111V', 202020, 2000, 2250),
(100002, 'niki', 'Savings account', '01.02.2020', 'male', 'colomb 7', '123456789V', 214587, 5000, 6500),
(100003, 'niki', 'Savings account', '01.02.2020', 'male', 'colomb 7', '123456789V', 214587, 5000, 5250),
(100004, 'yasi', 'Fix account', '10.20.97', 'male', 'rt', '12345678V', 213654, 1452, 7614),
(100005, 'bank2', 'Savings account', '2/3/1952', 'male', 'test streat', '123V', 123654, 5000, 6034.23),
(100006, 'henry', 'Savings account', '12/02/1965', 'male', 'henry house malabe', '451278369V', 112233445, 2000, 3000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`nic`);

--
-- Indexes for table `customer_acc`
--
ALTER TABLE `customer_acc`
  ADD PRIMARY KEY (`account_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer_acc`
--
ALTER TABLE `customer_acc`
  MODIFY `account_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100007;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
