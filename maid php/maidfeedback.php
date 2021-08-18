<?php
$u=$_POST['username'];
$f=$_POST['feedback'];



$un="root";
$pass="satvik123";
$host="localhost:3306";
$db="maid";
echo "$u<br>$f";
$conn=mysqli_connect($POST,$un,$pass,$db);
$sql="UPDATE maids SET username='$u',feedback='$f' WHERE username='$u'";

if(mysqli_query($conn,$sql))
{
	echo "record inserted";
}
else
{
	echo "record not inserted";
}
?>