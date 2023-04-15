
DROP TABLE IF EXISTS `post`;

CREATE TABLE `post`
(
    id            int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title         varchar(255) NOT NULL,
    content       varchar(255) NOT NULL,
    user_id        int NOT NULL,
    created_at     timestamp    NOT NULL,
    is_paid_content boolean DEFAULT false
);




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



ALTER TABLE `user` ADD COLUMN `avatar` varchar(255);



CREATE TABLE  `post_hint` (
`id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) NOT NULL,
  question varchar(255) NOT NULL,
  `hint_order` int(11) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL,
  PRIMARY KEY (`id`)
    
);


CREATE TABLE `answer` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `post_id` int(11) NOT NULL UNIQUE,
    `answer` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
    );    
    





