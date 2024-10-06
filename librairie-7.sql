-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 06, 2024 at 09:17 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `librairie`
--

-- --------------------------------------------------------

--
-- Table structure for table `auteurs`
--

CREATE TABLE `auteurs` (
  `auteur_id` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `nationalite` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `auteurs`
--

INSERT INTO `auteurs` (`auteur_id`, `nom`, `prenom`, `date_naissance`, `nationalite`) VALUES
(1, 'Martin', 'Julien', '1980-05-15', 'Français'),
(2, 'Dupont', 'Claire', '1975-11-23', 'Française'),
(3, 'Smith', 'John', '1990-02-10', 'Américain'),
(4, 'Garcia', 'Maria', '1985-08-30', 'Espagnole'),
(5, 'Rossi', 'Luca', '1992-03-25', 'Italien'),
(6, 'Müller', 'Anna', '1988-09-18', 'Allemande'),
(7, 'Chen', 'Wei', '1983-04-12', 'Chinoise'),
(8, 'Patel', 'Aisha', '1995-01-05', 'Indienne'),
(9, 'Johnson', 'Michael', '1982-06-20', 'Américain'),
(10, 'Lefèvre', 'Émilie', '1991-12-14', 'Française');

-- --------------------------------------------------------

--
-- Table structure for table `avis`
--

CREATE TABLE `avis` (
  `avis_id` int(11) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  `livre_id` int(11) DEFAULT NULL,
  `note` int(11) DEFAULT NULL,
  `commentaire` text DEFAULT NULL,
  `date_avis` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `avis`
--

INSERT INTO `avis` (`avis_id`, `client_id`, `livre_id`, `note`, `commentaire`, `date_avis`) VALUES
(1, 1, 1, 5, 'Excellent livre, très captivant!', '2024-10-01'),
(2, 2, 2, 4, 'Bonne lecture, mais un peu long.', '2024-10-02'),
(3, 3, 3, 3, 'Histoire intéressante, mais prévisible.', '2024-10-03'),
(4, 4, 4, 5, 'Un chef-d\'œuvre!', '2024-10-01'),
(5, 5, 5, 2, 'Pas à la hauteur des attentes.', '2024-10-04'),
(6, 6, 6, 4, 'Très bien écrit!', '2024-10-03'),
(7, 7, 7, 5, 'Je recommande vivement!', '2024-10-02'),
(8, 8, 8, 3, 'Assez bon, mais pourrait être mieux.', '2024-10-01'),
(9, 9, 9, 4, 'Une belle surprise!', '2024-10-04'),
(10, 10, 10, 5, 'Parfait, je l\'ai adoré!', '2024-10-03');

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `client_id` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `mot_de_passe` varchar(100) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`client_id`, `nom`, `prenom`, `email`, `telephone`, `mot_de_passe`, `adresse`) VALUES
(1, 'Martin', 'Paul', 'paul.martin@gmail.com', '0612345678', 'mdp123', '12 Rue de Paris, 75000'),
(2, 'Dupont', 'Sophie', 'sophie.dupont@hotmail.com', '0623456789', 'mdp456', '15 Avenue de Lyon, 69000'),
(3, 'Smith', 'James', 'james.smith@yahoo.com', '0634567890', 'mdp789', '25 Boulevard de Nice, 06000'),
(4, 'Garcia', 'Laura', 'laura.garcia@gmail.com', '0645678901', 'mdp101', '8 Rue de Marseille, 13000'),
(5, 'Rossi', 'Marco', 'marco.rossi@hotmail.com', '0656789012', 'mdp112', '45 Rue de Lille, 59000'),
(6, 'Müller', 'Hans', 'hans.mueller@yahoo.com', '0667890123', 'mdp131', '30 Rue de Berlin, 10115'),
(7, 'Chen', 'Ming', 'ming.chen@gmail.com', '0678901234', 'mdp415', '5 Rue de Pékin, 100000'),
(8, 'Patel', 'Aarti', 'aarti.patel@hotmail.com', '0689012345', 'mdp161', '20 Rue de Mumbai, 400000'),
(9, 'Johnson', 'Emily', 'emily.johnson@yahoo.com', '0690123456', 'mdp718', '7 Avenue de Toronto, M5H'),
(10, 'Lefèvre', 'Claire', 'claire.lefevre@gmail.com', '0701234567', 'mdp919', '10 Rue de Bruxelles, 1000'),
(11, 'Dupont', 'Jean', 'jean.dupont@example.com', '0123456789', 'motdepasse123', '123 Rue de Paris'),
(12, 'Dupont', 'Jean', 'jean.dupont@example.com', '0123456789', 'motdepasse123', '123 Rue de Paris'),
(13, 'Dupont', 'Jean', 'jean.dupont@example.com', '0123456789', 'motdepasse123', '123 Rue de Paris'),
(14, 'Dupont', 'Jean', 'jean.dupont@example.com', '0123456789', 'motdepasse123', '123 Rue de Paris'),
(15, 'Dupont', 'Jean', 'jean.dupont@example.com', '0123456789', 'motdepasse123', '123 Rue de Paris'),
(16, 'Dupont', 'Jean', 'jean.dupont@example.com', '0123456789', 'motdepasse123', '123 Rue de Paris');

-- --------------------------------------------------------

--
-- Table structure for table `commandes`
--

CREATE TABLE `commandes` (
  `commande_id` int(11) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  `date_commande` date DEFAULT NULL,
  `montant_total` decimal(10,2) DEFAULT NULL,
  `statut` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `commandes`
--

INSERT INTO `commandes` (`commande_id`, `client_id`, `date_commande`, `montant_total`, `statut`) VALUES
(1, 1, '2024-10-01', 50.00, 'validée'),
(2, 2, '2024-10-02', 75.00, 'en cours'),
(3, 3, '2024-10-03', 30.00, 'annulée'),
(4, 4, '2024-10-01', 45.00, 'livrée'),
(5, 5, '2024-10-04', 80.00, 'en cours'),
(6, 6, '2024-10-03', 65.00, 'livrée'),
(7, 7, '2024-10-02', 90.00, 'annulée'),
(8, 8, '2024-10-01', 55.00, 'validée'),
(9, 9, '2024-10-04', 40.00, 'en cours'),
(10, 10, '2024-10-03', 100.00, 'livrée'),
(11, 1, '2024-10-06', 100.00, 'en cours'),
(12, 1, '2024-10-06', 100.00, 'en cours');

-- --------------------------------------------------------

--
-- Table structure for table `details_commande`
--

CREATE TABLE `details_commande` (
  `detail_id` int(11) NOT NULL,
  `commande_id` int(11) DEFAULT NULL,
  `livre_id` int(11) DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `prix_unitaire` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `details_commande`
--

INSERT INTO `details_commande` (`detail_id`, `commande_id`, `livre_id`, `quantite`, `prix_unitaire`) VALUES
(1, 1, 1, 1, 25.00),
(2, 1, 2, 1, 25.00),
(3, 2, 3, 3, 25.00),
(4, 3, 4, 1, 30.00),
(5, 4, 5, 1, 45.00),
(6, 5, 6, 1, 80.00),
(7, 6, 7, 2, 32.50),
(8, 7, 8, 1, 45.00),
(9, 8, 9, 1, 55.00),
(10, 9, 10, 1, 40.00);

-- --------------------------------------------------------

--
-- Table structure for table `factures`
--

CREATE TABLE `factures` (
  `facture_id` int(11) NOT NULL,
  `commande_id` int(11) DEFAULT NULL,
  `montant_total` decimal(10,2) DEFAULT NULL,
  `date_facture` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `factures`
--

INSERT INTO `factures` (`facture_id`, `commande_id`, `montant_total`, `date_facture`) VALUES
(2, 2, 75.00, '2024-10-02'),
(3, 3, 30.00, '2024-10-03'),
(4, 4, 45.00, '2024-10-01'),
(5, 5, 80.00, '2024-10-04'),
(6, 6, 65.00, '2024-10-03'),
(7, 7, 90.00, '2024-10-02'),
(8, 8, 55.00, '2024-10-01'),
(9, 9, 40.00, '2024-10-04'),
(10, 10, 100.00, '2024-10-03'),
(11, 1, 100.50, '2024-10-06');

-- --------------------------------------------------------

--
-- Table structure for table `genres`
--

CREATE TABLE `genres` (
  `genre_id` int(11) NOT NULL,
  `nom_genre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `genres`
--

INSERT INTO `genres` (`genre_id`, `nom_genre`) VALUES
(1, 'Science-fiction'),
(2, 'Roman'),
(3, 'Fantastique'),
(4, 'Thriller'),
(5, 'Biographie'),
(6, 'Historique'),
(7, 'Romance'),
(8, 'Aventure'),
(9, 'Poésie'),
(10, 'Essai');

-- --------------------------------------------------------

--
-- Table structure for table `livres`
--

CREATE TABLE `livres` (
  `livre_id` int(11) NOT NULL,
  `titre` varchar(100) DEFAULT NULL,
  `auteur_id` int(11) DEFAULT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `prix` decimal(10,2) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `livres`
--

INSERT INTO `livres` (`livre_id`, `titre`, `auteur_id`, `genre_id`, `prix`, `description`, `stock`) VALUES
(1, '1984', 2, 1, 17.99, 'Dystopie de George Orwell', 30),
(2, 'Voyage à travers le temps', 2, 1, 25.00, 'Une aventure à travers les âges.', 5),
(3, 'Les secrets de la forêt', 3, 4, 30.00, 'Un thriller qui vous tiendra en haleine.', 8),
(4, 'La voix des ancêtres', 4, 5, 45.00, 'Biographie d\'un grand leader.', 3),
(5, 'Les étoiles de l\'espoir', 5, 7, 80.00, 'Un roman d\'amour touchant.', 7),
(6, 'Histoires de l\'Antiquité', 6, 6, 32.50, 'Exploration des récits anciens.', 12),
(7, 'Les chemins de l\'aventure', 7, 8, 40.00, 'Un récit d\'aventure inoubliable.', 15),
(8, 'Rêves et réalités', 8, 3, 55.00, 'Un roman fantastique unique.', 6),
(9, 'Paroles de sages', 9, 9, 40.00, 'Un recueil de poésie émouvante.', 9),
(10, 'La pensée critique', 10, 10, 100.00, 'Un essai sur l\'analyse critique.', 2),
(12, 'Le Petit Prince', 1, 1, 12.99, 'Un livre sur l\'amitié et l\'amour.', 5),
(13, 'Le Petit Prince', 1, 1, 12.99, 'Un livre sur l\'amitié et l\'amour.', 5);

-- --------------------------------------------------------

--
-- Table structure for table `methodes_paiement`
--

CREATE TABLE `methodes_paiement` (
  `methode_id` int(11) NOT NULL,
  `nom_methode` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `methodes_paiement`
--

INSERT INTO `methodes_paiement` (`methode_id`, `nom_methode`) VALUES
(1, 'Carte bancaire'),
(2, 'PayPal'),
(3, 'Virement bancaire'),
(4, 'Chèque'),
(5, 'Espèces');

-- --------------------------------------------------------

--
-- Table structure for table `panier`
--

CREATE TABLE `panier` (
  `panier_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `date_creation` date NOT NULL,
  `montant_total` decimal(10,2) DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `panier`
--

INSERT INTO `panier` (`panier_id`, `client_id`, `date_creation`, `montant_total`) VALUES
(1, 1, '2024-10-06', 60.98);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `auteurs`
--
ALTER TABLE `auteurs`
  ADD PRIMARY KEY (`auteur_id`);

--
-- Indexes for table `avis`
--
ALTER TABLE `avis`
  ADD PRIMARY KEY (`avis_id`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`client_id`);

--
-- Indexes for table `commandes`
--
ALTER TABLE `commandes`
  ADD PRIMARY KEY (`commande_id`);

--
-- Indexes for table `factures`
--
ALTER TABLE `factures`
  ADD PRIMARY KEY (`facture_id`);

--
-- Indexes for table `genres`
--
ALTER TABLE `genres`
  ADD PRIMARY KEY (`genre_id`);

--
-- Indexes for table `livres`
--
ALTER TABLE `livres`
  ADD PRIMARY KEY (`livre_id`),
  ADD KEY `auteur_id` (`auteur_id`),
  ADD KEY `genre_id` (`genre_id`);

--
-- Indexes for table `methodes_paiement`
--
ALTER TABLE `methodes_paiement`
  ADD PRIMARY KEY (`methode_id`);

--
-- Indexes for table `panier`
--
ALTER TABLE `panier`
  ADD PRIMARY KEY (`panier_id`),
  ADD KEY `client_id` (`client_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `avis`
--
ALTER TABLE `avis`
  MODIFY `avis_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `client_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `commandes`
--
ALTER TABLE `commandes`
  MODIFY `commande_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `factures`
--
ALTER TABLE `factures`
  MODIFY `facture_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `livres`
--
ALTER TABLE `livres`
  MODIFY `livre_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `panier`
--
ALTER TABLE `panier`
  MODIFY `panier_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `livres`
--
ALTER TABLE `livres`
  ADD CONSTRAINT `livres_ibfk_1` FOREIGN KEY (`auteur_id`) REFERENCES `auteurs` (`auteur_id`),
  ADD CONSTRAINT `livres_ibfk_2` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`genre_id`);

--
-- Constraints for table `panier`
--
ALTER TABLE `panier`
  ADD CONSTRAINT `panier_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
