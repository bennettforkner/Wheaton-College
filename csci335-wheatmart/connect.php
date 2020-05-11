<?php
echo "I'm Working!!!!!!!!!!!!!!";
$title = filter_input(INPUT_POST, 'Title');
$author = filter_input(INPUT_POST, 'Author');
$condition = filter_input(INPUT_POST, 'Condition');
$askingPrice = filter_input(INPUT_POST, 'Asking Price');
$imageURL = filter_input(INPUT_POST, 'Image URL');

if (!empty($title)) {
	if (!empty($author)) {
		if (!empty($condition)) {
			if (!empty($askingPrice)) {
				if (!empty($imageURL)) {
					$host = "remotemysql.com";
					$dbusername = "Oqk3e9dlPh";
					$dbpassword = "582ytiLiLC";
					$dbname = "Oqk3e9dlPh";

					//Create connection
					$conn = new mysqli ($host, $dbusername, $dbpassword, $dbname);

					if (mysqli_connect_error()) {
						die ('Connect Error ('. mysqli_connect_errno() .') ' . mysqli_connect_error());
					} else {
						$sql = "INSERT INTO account (title, account, condition, askingPrice, imageURL) values ('$title, $author, $condition, $askingPrice, $imageURL')";
						if ($conn->query($sql)) {
							echo "New record is inserted successfully";
						}
					}
				}
				else {
					echo "Image URL should not be empty.";
					die();
				}
			}
			else {
				echo "Asking Price should not be empty.";
				die();
			}
		}
		else {
			echo "Condition should not be empty.";
			die();
		}
	}
	else {
		echo "Author should not be empty.";
		die();
	}
}
else {
	echo "Title should not be empty.";
	die();
}

?>
