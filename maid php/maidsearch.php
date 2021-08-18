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

$stmt =$conn->prepare("SELECT username,password,age,mob,gender,state,city,locality,feedback FROM maids");

$stmt->execute();

$stmt->bind_result($username,$password,$age,$mob,$gender,$state,$city,$locality,$feedback);
$use=array();

while($stmt->fetch())
{
$temp=array();
$temp['username']=$username;
$temp['password']=$password;
$temp['age']=$age;
$temp['mob']=$mob;
$temp['gender']=$gender;
$temp['state']=$state;
$temp['city']=$city;
$temp['locality']=$locality;
$temp['feedback']=$feedback;

array_push($use,$temp);
}



echo json_encode($use);

?>
