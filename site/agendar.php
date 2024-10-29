<?php
include 'config.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $id_servico = $_POST['servico'];
    $data = $_POST['data'];
    $horario = $_POST['horario'];
    $nome_cliente = $_POST['nome'];
    $telefone_cliente = $_POST['telefone'];

    echo "Valor de id_servico recebido: " . $id_servico . "<br>";

    if (!is_numeric($id_servico) || $id_servico < 1 || $id_servico > 5) {
        echo "Erro: id_servico inválido.";
        exit();
    }

    $sql = "INSERT INTO agendamentos (id_servico, data, horario, nome_cliente, telefone_cliente) VALUES (?, ?, ?, ?, ?)";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("issss", $id_servico, $data, $horario, $nome_cliente, $telefone_cliente);

    if ($stmt->execute()) {
        echo "Agendamento confirmado!";
    } else {
        echo "Erro ao confirmar agendamento: " . $stmt->error;
    }

    $stmt->close();
}
$conn->close();
?>