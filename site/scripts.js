function openBooking() {
    document.getElementById('tela').style.display = 'flex';
}

function closetela() {
    document.getElementById('tela').style.display = 'none';
}

document.getElementById('bookingForm').addEventListener('submit', function(event) {
    event.preventDefault();
    alert("Agendamento confirmado!");
    closeModal();
});

function openInfoModal() {
    document.getElementById('infoModal').style.display = 'flex';
}

function closeInfoModal() {
    document.getElementById('infoModal').style.display = 'none';
}

// Adiciona evento ao botão "Informações da barbearia"
document.querySelector('.menu-btn.informacoes').addEventListener('click', openInfoModal);

function openProfile() {
    document.getElementById('profileModal').style.display = 'flex';
}

function closeProfile() {
    document.getElementById('profileModal').style.display = 'none';
}

function showTab(tabId) {
    // Esconde todas as abas
    document.querySelectorAll('.tab-content').forEach(tab => tab.style.display = 'none');
    // Exibe a aba selecionada
    document.getElementById(tabId).style.display = 'block';
}

// Exibir por padrão a aba de "Agendamentos atuais"
showTab('current');

function toggleDarkMode() {
    document.body.classList.toggle('dark-mode');

    // Alterna o texto do botão entre "Modo Escuro" e "Modo Claro"
    const btn = document.querySelector('.dark-mode-toggle');
    if (document.body.classList.contains('dark-mode')) {
        btn.textContent = '☀️ Modo Claro';
    } else {
        btn.textContent = '🌙 Modo Escuro';
    }
}

// Verifica a preferência de modo escuro ao carregar a página
window.addEventListener('load', () => {
    if (localStorage.getItem('dark-mode') === 'true') {
        document.body.classList.add('dark-mode');
        document.querySelector('.dark-mode-toggle').textContent = '☀️ Modo Claro';
    }
});

function toggleDarkMode() {
    document.body.classList.toggle('dark-mode');
    const isDarkMode = document.body.classList.contains('dark-mode');
    
    // Salva a preferência no localStorage
    localStorage.setItem('dark-mode', isDarkMode);

    // Alterna o texto do botão
    const btn = document.querySelector('.dark-mode-toggle');
    btn.textContent = isDarkMode ? '☀️ Modo Claro' : '🌙 Modo Escuro';
}
