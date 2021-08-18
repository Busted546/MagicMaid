<?php

define('DB_HOST','localhost');
define('DB_USER','root');
define('DB_PASS','satvik123');
define('DB_NAME','maid');

$conn = new mysqli(DB_HOST,DB_USER,DB_PASS,DB_NAME);

if(mysqli_connect_errno())
{
echo "Failed to connect MySQL:".mysqli_connect_error();
die();
}

$stmt = $conn->prepare("SELECT name, password, email, contact FROM user");
$stmt->execute();
$stmt->bind_result($name,$password,$email,$contact);
$notice=array();
while($stmt->fetch())
{
$temp=array();
$temp['name']=$name;
$temp['password']=$password;
$temp['email']=$email;
$temp['contact']=$contact;
array_push($notice,$temp);
}
echo json_encode($notice);

?>