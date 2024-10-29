<?php
ini_set('display_errors', 1);
error_reporting(E_ALL);
include 'config.php';

header('Content-Type: application/json');

$id_cliente = 1; 

$sql_current = "SELECT a.data, a.horario, a.nome_cliente, s.nome_servico, s.preco 
                FROM agendamentos a 
                JOIN Servicos s ON a.id_servico = s.id_servico 
                WHERE a.data >= CURDATE() AND a.nome_cliente = ?";
$stmt_current = $conn->prepare($sql_current);
$stmt_current->bind_param("s", $id_cliente);
$stmt_current->execute();
$result_current = $stmt_current->get_result();

$sql_completed = "SELECT a.data, a.horario, a.nome_cliente, s.nome_servico, s.preco 
                  FROM agendamentos a 
                  JOIN Servicos s ON a.id_servico = s.id_servico 
                  WHERE a.data < CURDATE() AND a.nome_cliente = ?";
$stmt_completed = $conn->prepare($sql_completed);
$stmt_completed->bind_param("s", $id_cliente);
$stmt_completed->execute();
$result_completed = $stmt_completed->get_result();

$current_appointments = [];
$completed_appointments = [];

while ($row = $result_current->fetch_assoc()) {
    $current_appointments[] = $row;
}

while ($row = $result_completed->fetch_assoc()) {
    $completed_appointments[] = $row;
}

$stmt_current->close();
$stmt_completed->close();
$conn->close();

echo json_encode([
    'current' => $current_appointments,
    'completed' => $completed_appointments
]);
?>