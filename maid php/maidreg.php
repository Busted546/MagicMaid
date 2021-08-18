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
$f=$_POST['feedback'];



$un="root";
$pass="satvik123";
$host="127.0.0.1:3306";
$db="maid";

echo "$u<br>$p<br>$a<br>$m<br>$g<br>$s<br>$c<br>$l<br>$q1<br>$q2<br>$q3<br>$q4<br>$q5<br>$q6";
$conn=mysqli_connect($host,$un,$pass,$db);
$sql="insert into maids values('$u','$p','$a','$m','$g','$s','$c','$l','$q1','$q2','$q3','$q4','$q5','$q6','$f')";
if(mysqli_query($conn,$sql))
{
	echo "record inserted";
}
else
{
	echo "record not inserted";
}
?>