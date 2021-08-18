<?php

define('DB_HOST','localhost');
define('DB_USER','root');
define('DB_PASS','satvik123');
define('DB_NAME','maid');
$u= $_POST['name'];

$conn = new mysqli(DB_HOST,DB_USER,DB_PASS,DB_NAME);

if($conn->connect_error)
{
die("connection failed: " . $conn->connect_error);
}

$sql = "DELETE FROM user WHERE name='$u'";
if($conn->query($sql) === TRUE)
{
echo "Record deleted successfully";
}
else
{
echo "Error deleting record: " . $conn->error;
}

$conn->close();
?>