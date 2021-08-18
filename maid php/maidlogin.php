<?php

define('DB_HOST','localhost');
define('DB_USER','root');
define('DB_PASS','satvik123');
define('DB_NAME','maid');


$conn=new mysqli(DB_HOST,DB_USER,DB_PASS,DB_NAME);
if(mysqli_connect_errno())
{
echo"Failed to connect to MySQL:".mysqli_connect_error();
die();
}

$stmt=$conn->prepare("SELECT username,password FROM maids");
$stmt->execute();

$stmt->bind_result($username,$password);
$notice=array();

while($stmt->fetch())
{
$temp=array();
$temp['username']=$username;
$temp['password']=$password;

array_push($notice,$temp);
}
echo json_encode($notice);
?>