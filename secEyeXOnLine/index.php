<?php
$usernameServer = "massina";
$passwordServer = password_hash("aa", PASSWORD_DEFAULT);
$data = [];

if (isset($_POST['password']) && isset($_POST['username'])) {
    $username = $_POST['username'];
    $password = $_POST['password']; 


    if ($username === $usernameServer && password_verify($password, $passwordServer)) {
        $success = true;
        $message = 'authentification réussi';
        $http_status = 200;
        $data = ["username" => $usernameServer, "password"=>$passwordServer ];

    } else {
        $success = false;
        $message = 'credential incorrect';
        $http_status = 401; 
    }
} else {
    $success = false;
    $message = 'username ou password non reçu';

    $http_status = 400; 
}

$response = array('success' => $success, 'message' => $message,'httpStatus'=>$http_status, "data"=> $data);
$jsonResponse = json_encode($response);

http_response_code($http_status);
header('Content-Type: application/json');
echo $jsonResponse;
?>
