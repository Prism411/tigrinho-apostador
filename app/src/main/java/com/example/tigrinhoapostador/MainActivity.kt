package com.example.tigrinhoapostador

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    
    // COMPONENTE 1 - ImageView: Exibe a imagem/ícone do tigrinho
    private lateinit var tigerImage: ImageView
    
    // COMPONENTE 2 - TextView: Múltiplos usos para exibir textos (saldo, resultado, mensagens)
    private lateinit var balanceText: TextView
    private lateinit var resultText: TextView
    private lateinit var motivationalText: TextView
    private lateinit var statsText: TextView
    
    // COMPONENTE 3 - EditText: Campo de entrada para o usuário digitar o valor da aposta
    private lateinit var betAmount: EditText
    
    // COMPONENTE 4 - RadioGroup e RadioButton: Seleção de multiplicador (2x, 5x, 10x)
    private lateinit var multiplierGroup: RadioGroup
    
    // COMPONENTE 5 - CheckBox: Caixa de seleção para aceitar os termos sarcásticos
    private lateinit var termsCheckbox: CheckBox
    
    // COMPONENTE 6 - Spinner: Menu dropdown para escolher o tigre da sorte
    private lateinit var tigerSpinner: Spinner
    
    // COMPONENTE 7 - Button: Botão principal para realizar a aposta
    private lateinit var betButton: Button
    
    // COMPONENTE 8 - ProgressBar: Barra de progresso horizontal durante a animação
    private lateinit var progressBar: ProgressBar
    
    private var balance = 100.0
    private var totalLosses = 0.0
    private var consecutiveLosses = 0
    
    private val sarcasticMessages = listOf(
        "Parabéns! Você descobriu um novo jeito de ficar pobre!",
        "O tigrinho agradece sua generosa doação!",
        "Sua carteira está mais leve, mas seu coração... também!",
        "Quem precisa de dinheiro quando se tem esperança? (Spoiler: você)",
        "O tigrinho está rindo... mas não com você, DE você!",
        "Investimento? Mais para desperdício garantido!",
        "Sua habilidade em perder dinheiro é impressionante!",
        "O tigrinho comprou um iate com seu dinheiro!",
        "Parabéns! Você é o cliente favorito do tigrinho!",
        "Dica: Guardar dinheiro no colchão é mais lucrativo!"
    )
    
    private val winMessages = listOf(
        "MILAGRE! Você ganhou! (Aproveite, não vai durar)",
        "Bug no sistema! Você ganhou! Vamos corrigir isso já já...",
        "Ganhou? Deve ser seu dia de sorte... ou o último!",
        "O tigrinho teve pena de você... dessa vez!",
        "Erro 404: Derrota não encontrada (temporariamente)"
    )
    
    private val tigerNames = listOf(
        "Tigrinho Ladrão",
        "Tigrinho Malandro",
        "Tigrinho Pilantra",
        "Tigrinho Espertalhão",
        "Tigrinho Quebra-Banco (o seu)",
        "Tigrinho Milionário (com seu dinheiro)",
        "Tigrinho Sortudo (você não)"
    )
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        initViews()
        setupSpinner()
        setupListeners()
        updateBalance()
    }
    
    private fun initViews() {
        // COMPONENTE 1 - ImageView: Inicialização da imagem do tigrinho
        tigerImage = findViewById(R.id.tigerImage)
        
        // COMPONENTE 2 - TextView: Inicialização dos textos
        balanceText = findViewById(R.id.balanceText)
        resultText = findViewById(R.id.resultText)
        motivationalText = findViewById(R.id.motivationalText)
        statsText = findViewById(R.id.statsText)
        
        // COMPONENTE 3 - EditText: Inicialização do campo de entrada
        betAmount = findViewById(R.id.betAmount)
        
        // COMPONENTE 4 - RadioGroup: Inicialização do grupo de opções
        multiplierGroup = findViewById(R.id.multiplierGroup)
        
        // COMPONENTE 5 - CheckBox: Inicialização da caixa de seleção
        termsCheckbox = findViewById(R.id.termsCheckbox)
        
        // COMPONENTE 6 - Spinner: Inicialização do menu dropdown
        tigerSpinner = findViewById(R.id.tigerSpinner)
        
        // COMPONENTE 7 - Button: Inicialização do botão de aposta
        betButton = findViewById(R.id.betButton)
        
        // COMPONENTE 8 - ProgressBar: Inicialização da barra de progresso
        progressBar = findViewById(R.id.progressBar)
    }
    
    private fun setupSpinner() {
        // COMPONENTE 6 - Spinner: Configuração do menu dropdown com lista de tigres
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tigerNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tigerSpinner.adapter = adapter
    }
    
    private fun setupListeners() {
        // COMPONENTE 7 - Button: Configuração do clique do botão de aposta
        betButton.setOnClickListener {
            if (validateBet()) {
                placeBet()
            }
        }
        
        // COMPONENTE 5 - CheckBox: Listener para habilitar/desabilitar botão
        termsCheckbox.setOnCheckedChangeListener { _, isChecked ->
            betButton.isEnabled = isChecked
            if (isChecked) {
                // COMPONENTE 9 - Toast: Exibe mensagem temporária na tela
                Toast.makeText(this, "Decisão sábia! (Mentira)", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    private fun validateBet(): Boolean {
        // COMPONENTE 3 - EditText: Obtendo o texto digitado pelo usuário
        val betStr = betAmount.text.toString()
        
        if (betStr.isEmpty()) {
            // COMPONENTE 9 - Toast: Mensagem de erro para campo vazio
            Toast.makeText(this, "Digite um valor para perder!", Toast.LENGTH_SHORT).show()
            return false
        }
        
        val bet = betStr.toDoubleOrNull() ?: 0.0
        
        if (bet <= 0) {
            // COMPONENTE 9 - Toast: Mensagem de erro para valor inválido
            Toast.makeText(this, "O valor precisa ser maior que zero!", Toast.LENGTH_SHORT).show()
            return false
        }
        
        if (bet > balance) {
            // COMPONENTE 9 - Toast: Mensagem de erro para saldo insuficiente
            Toast.makeText(this, "Você não tem tanto dinheiro para perder! Ainda...", Toast.LENGTH_LONG).show()
            return false
        }
        
        // COMPONENTE 5 - CheckBox: Verificando se os termos foram aceitos
        if (!termsCheckbox.isChecked) {
            // COMPONENTE 9 - Toast: Mensagem de erro para termos não aceitos
            Toast.makeText(this, "Aceite perder seu dinheiro primeiro!", Toast.LENGTH_SHORT).show()
            return false
        }
        
        return true
    }
    
    private fun placeBet() {
        // COMPONENTE 3 - EditText: Obtendo valor digitado
        val bet = betAmount.text.toString().toDouble()
        // COMPONENTE 4 - RadioGroup: Obtendo multiplicador selecionado
        val multiplier = getSelectedMultiplier()
        
        // COMPONENTE 7 - Button: Desabilitando durante processamento
        betButton.isEnabled = false
        // COMPONENTE 2 - TextView: Limpando textos de resultado
        resultText.text = ""
        motivationalText.text = ""
        // COMPONENTE 8 - ProgressBar: Exibindo barra de progresso
        progressBar.visibility = View.VISIBLE
        
        // COMPONENTE 1 - ImageView: Iniciando animação do tigre
        animateTiger()
        // COMPONENTE 8 - ProgressBar: Iniciando animação da barra
        animateProgress()
        
        Handler(Looper.getMainLooper()).postDelayed({
            val won = calculateResult(multiplier)
            val winAmount = if (won) bet * multiplier else 0.0
            
            if (won) {
                balance += winAmount - bet
                resultText.text = "GANHOU R$ ${String.format("%.2f", winAmount)}"
                resultText.setTextColor(getColor(R.color.green))
                motivationalText.text = winMessages.random()
                consecutiveLosses = 0
            } else {
                balance -= bet
                totalLosses += bet
                consecutiveLosses++
                resultText.text = "PERDEU R$ ${String.format("%.2f", bet)}"
                resultText.setTextColor(getColor(R.color.red))
                motivationalText.text = sarcasticMessages.random()
                
                if (consecutiveLosses >= 3) {
                    motivationalText.text = "${motivationalText.text}\n\n${consecutiveLosses} derrotas seguidas! Novo recorde!"
                }
            }
            
            updateBalance()
            updateStats()
            progressBar.visibility = View.GONE
            betButton.isEnabled = true
            
            if (balance <= 0) {
                showGameOver()
            }
            
        }, 3000)
    }
    
    private fun getSelectedMultiplier(): Double {
        // COMPONENTE 4 - RadioGroup: Obtendo qual RadioButton foi selecionado
        return when (multiplierGroup.checkedRadioButtonId) {
            R.id.radio2x -> 2.0
            R.id.radio5x -> 5.0
            R.id.radio10x -> 10.0
            else -> 2.0
        }
    }
    
    private fun calculateResult(multiplier: Double): Boolean {
        val chance = when (multiplier) {
            2.0 -> 0.4  // 40% de chance
            5.0 -> 0.15 // 15% de chance
            10.0 -> 0.05 // 5% de chance
            else -> 0.3
        }
        
        return Random.nextDouble() < chance
    }
    
    private fun animateTiger() {
        // COMPONENTE 1 - ImageView: Animação de rotação do tigre
        val rotation = ObjectAnimator.ofFloat(tigerImage, "rotation", 0f, 360f)
        rotation.duration = 3000
        rotation.start()
    }
    
    private fun animateProgress() {
        // COMPONENTE 8 - ProgressBar: Animação de progresso de 0 a 100
        val animator = ObjectAnimator.ofInt(progressBar, "progress", 0, 100)
        animator.duration = 3000
        animator.start()
    }
    
    private fun updateBalance() {
        // COMPONENTE 2 - TextView: Atualizando texto do saldo
        balanceText.text = "R$ ${String.format("%.2f", balance)}"
        if (balance < 50) {
            balanceText.setTextColor(getColor(R.color.red))
        } else {
            balanceText.setTextColor(getColor(R.color.green))
        }
    }
    
    private fun updateStats() {
        // COMPONENTE 2 - TextView: Atualizando estatísticas de perdas
        statsText.text = "Perdas acumuladas: R$ ${String.format("%.2f", totalLosses)}"
    }
    
    private fun showGameOver() {
        // COMPONENTE 2 - TextView: Exibindo mensagens de game over
        resultText.text = "GAME OVER! Você perdeu tudo!"
        motivationalText.text = "O tigrinho agradece sua contribuição para o fundo de aposentadoria dele!"
        // COMPONENTE 7 - Button: Desabilitando botão
        betButton.isEnabled = false
        // COMPONENTE 3 - EditText: Desabilitando campo de entrada
        betAmount.isEnabled = false
        
        Handler(Looper.getMainLooper()).postDelayed({
            // COMPONENTE 9 - Toast: Mensagem de reinício
            Toast.makeText(this, "Reiniciando com mais R$ 100 de ilusão...", Toast.LENGTH_LONG).show()
            balance = 100.0
            updateBalance()
            // COMPONENTE 7 - Button: Reabilitando botão
            betButton.isEnabled = true
            // COMPONENTE 3 - EditText: Reabilitando campo de entrada
            betAmount.isEnabled = true
        }, 3000)
    }
}