package com.medicare.medicine.domain.model

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.time.LocalTime
import java.util.*

@Entity
@Table(name = "medicine")
@Data
@NoArgsConstructor
@AllArgsConstructor
class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: UUID? = null

    @Column(nullable = false)
    private var nome: String? = null

    @Column(nullable = false)
    private var tipo: String? = null // Enum or String (use Enum if needed, example below)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private var usoPermitido: UsageType? = null // Enum: HUMAN, ANIMAL, BOTH

    @Column(name = "imagem_medicamento")
    private var imagemMedicamento: String? = null

    @Column(name = "para_que_serve")
    private var paraQueServe: String? = null

    @Column(name = "horario_recomendado")
    private var horarioRecomendado: LocalTime? = null

    @Column
    private var bula: String? = null

    @ElementCollection // Maps a simple list to a secondary table
    @CollectionTable(name = "medicine_reactions", joinColumns = [JoinColumn(name = "medicine_id")])
    @Column(name = "reaction")
    private var possiveisReacoes: List<String>? = null

    @Column(name = "necessita_receita", nullable = false)
    private var necessitaReceita: Boolean? = null

    // Internal Enum for UsageType
    enum class UsageType {
        HUMAN, ANIMAL, BOTH
    }
}