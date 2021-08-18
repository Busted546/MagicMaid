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
$stmt=$conn->prepare("SELECT username,q1,q2,q3,q4,q5,q6 FROM maids");

$stmt->execute();
$stmt->bind_result($username,$q1,$q2,$q3,$q4,$q5,$q6);
$notice=array();
while($stmt->fetch())
{
$temp=array();
$temp['username']=$username;
$temp['q1']=$q1;
$temp['q2']=$q2;
$temp['q3']=$q3;
$temp['q4']=$q4;
$temp['q5']=$q5;
$temp['q6']=$q6;


array_push($notice,$temp);
}
echo json_encode($notice);
?>