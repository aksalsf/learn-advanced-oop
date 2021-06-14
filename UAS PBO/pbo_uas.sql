-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2021 at 04:09 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo_uas`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_admin`
--

CREATE TABLE `tb_admin` (
  `id_admin` int(3) NOT NULL,
  `username` varchar(24) NOT NULL,
  `email` char(64) NOT NULL,
  `password` char(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_admin`
--

INSERT INTO `tb_admin` (`id_admin`, `username`, `email`, `password`) VALUES
(1, 'admin', 'admin@hotel.com', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kamar`
--

CREATE TABLE `tb_kamar` (
  `id_kamar` int(3) NOT NULL,
  `is_available` tinyint(1) NOT NULL DEFAULT 1,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_kamar`
--

INSERT INTO `tb_kamar` (`id_kamar`, `is_available`, `timestamp`) VALUES
(1, 0, '2021-06-14 00:58:59'),
(2, 1, '2021-06-14 00:39:55'),
(3, 1, '2021-06-13 16:11:37'),
(4, 0, '2021-06-14 01:17:03'),
(6, 1, '2021-06-13 16:36:26');

-- --------------------------------------------------------

--
-- Table structure for table `tb_reservasi`
--

CREATE TABLE `tb_reservasi` (
  `id_reservasi` int(3) NOT NULL,
  `id_kamar` int(3) NOT NULL,
  `nama_pengunjung` varchar(64) NOT NULL,
  `no_ktp` char(14) NOT NULL,
  `no_telp` char(12) NOT NULL,
  `email` varchar(64) NOT NULL,
  `alamat` text NOT NULL,
  `durasi` int(2) NOT NULL,
  `is_cancel` tinyint(1) NOT NULL,
  `is_paid` tinyint(1) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_reservasi`
--

INSERT INTO `tb_reservasi` (`id_reservasi`, `id_kamar`, `nama_pengunjung`, `no_ktp`, `no_telp`, `email`, `alamat`, `durasi`, `is_cancel`, `is_paid`, `timestamp`) VALUES
(1, 1, 'Kessa Muflih', '77698621215033', '085647216632', 'kessa@gmail.com', 'Mojosongo, Solo', 1, 0, 1, '2021-06-14 00:54:48'),
(2, 6, 'Budi', '88876549421201', '087645666232', 'budi@gmail.com', 'Solo', 1, 1, 0, '2021-06-14 00:54:52'),
(4, 1, 'Thaariq Moh. Aqshal', '88765524110932', '086523455521', 'tma@gmail.com', 'Sukoharjo', 3, 0, 0, '2021-06-14 00:58:12'),
(5, 4, 'Heru Wijaksono', '44421011500001', '086256766621', 'heru.w@gmail.com', 'Wonosobo', 2, 0, 0, '2021-06-14 01:17:03');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_admin`
--
ALTER TABLE `tb_admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `tb_kamar`
--
ALTER TABLE `tb_kamar`
  ADD PRIMARY KEY (`id_kamar`);

--
-- Indexes for table `tb_reservasi`
--
ALTER TABLE `tb_reservasi`
  ADD PRIMARY KEY (`id_reservasi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_admin`
--
ALTER TABLE `tb_admin`
  MODIFY `id_admin` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_kamar`
--
ALTER TABLE `tb_kamar`
  MODIFY `id_kamar` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tb_reservasi`
--
ALTER TABLE `tb_reservasi`
  MODIFY `id_reservasi` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
