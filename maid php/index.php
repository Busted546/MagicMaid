<?php

$n=$_POST['name'];
$p=$_POST['password'];
$e=$_POST['email'];
$c=$_POST['contact'];

$un="root";
$pass="satvik123";
$host="127.0.0.1:3306";
$db="maid";

echo"$n<br>$p<br>$e<br>$c";

$conn=mysqli_connect($host,$un,$pass,$db);

$sql="insert into user values('$n','$p','$e','$c')";
if(mysqli_query($conn,$sql))
{
echo"record added";
}
else
{
echo"record not added";
}

?>
