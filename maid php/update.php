<?php

$u=$_POST['name'];
$p=$_POST['password'];
$e=$_POST['email'];
$c=$_POST['contact'];

$un="root";
$pass="satvik123";
$host="127.0.0.1:3306";
$db="maid";

echo"$n<br>$p<br>$e<br>$c";
$conn=mysqli_connect($POST,$un,$pass,$db);

$sql="UPDATE user SET name='$u', email='$e', password='$p', contact='$c' WHERE name='$u'";
if(mysqli_query($conn,$sql))
{
echo"record updated";
}
else
{
echo"record not updated";
}

?>