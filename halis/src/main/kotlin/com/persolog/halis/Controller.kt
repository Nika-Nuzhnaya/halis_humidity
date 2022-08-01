package com.persolog.halis

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import com.persolog.halis.Selected as Selected

@Controller
class Controller {
    @GetMapping("/")
    fun main(model: MutableMap<String?, Any?>): String {
        var isEmptyTank: Boolean = false
        model["currentHumidity"] = (20..60).random().toByte()
        val currentWaterLevel: Byte = (0..5).random().toByte()
        if (currentWaterLevel == 0.toByte() || currentWaterLevel == 1.toByte()) {
            isEmptyTank = true
        }
        model["isEmptyTank"] = isEmptyTank
        model["currentWaterLevel"] = currentWaterLevel

        return "main"
    }

    @PostMapping("mode")
    fun modeSelection(selected: Selected<String>): String {

        return if (selected.mode == 1.toByte()) {
            "mode1"
        } else if (selected.mode == 2.toByte()) {
            "mode2"
        } else
            "mode3"
    }

}