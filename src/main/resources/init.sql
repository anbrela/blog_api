

CREATE TABLE `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL
);

INSERT INTO `user` (`id`, `username`, `password`, `email`, `created_at`, `updated_at`) VALUES
(1, 'admin', 'admin1234', 'admin@admin.com', LOCALTIMESTAMP, LOCALTIMESTAMP);