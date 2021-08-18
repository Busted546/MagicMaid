<?php

$u=$_POST['username'];
$p=$_POST['password'];
$a=$_POST['age'];
$m=$_POST['mob'];
$g=$_POST['gender'];
$s=$_POST['state'];
$c=$_POST['city'];
$l=$_POST['locality'];

$q1=$_POST['q1'];
$q2=$_POST['q2'];
$q3=$_POST['q3'];
$q4=$_POST['q4'];
$q5=$_POST['q5'];
$q6=$_POST['q6'];

$un="root";
$pass="satvik123";
$host="localhost:3306";
$db="maid";
echo "$u<br>$p<br>$e<br>$c";
$conn=mysqli_connect($POST,$un,$pass,$db);
$sql="UPDATE maids SET username='$u',password='$p',age='$a',mob='$m',gender='$g',state='$s',city='$c',locality='$l',q1='$q1',q2='$q2',q3='$q3',q4='$q4',q5='$q5',q6='$q6' WHERE username='$u'";

if(mysqli_query($conn,$sql))
{
	echo "record inserted";
}
else
{
	echo "record not inserted";
}
?>