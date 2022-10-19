package com.example.shotaro_kumagai_stress_master.ui.results

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.shotaro_kumagai_stress_master.GStringWriter
import com.example.shotaro_kumagai_stress_master.Player
import com.example.shotaro_kumagai_stress_master.R
import com.example.shotaro_kumagai_stress_master.ui.stressMeter.SelectImage
import com.opencsv.CSVIterator
import com.opencsv.CSVReader
import lecho.lib.hellocharts.model.*
import lecho.lib.hellocharts.view.LineChartView
import org.w3c.dom.Text
import java.io.StringReader
import java.io.StringWriter

class ResultFragment : Fragment() {
    private lateinit var resultView: View
    private lateinit var playerApp: Player
    private lateinit var lineChart: LineChartView
    private lateinit var value: ArrayList<PointValue>
    private lateinit var axisBottom: ArrayList<AxisValue>
    private lateinit var axisLeft: ArrayList<AxisValue>
    private lateinit var stringReader: StringReader
    private lateinit var stringWriter:StringWriter
    private lateinit var csvIterator: CSVIterator
    private lateinit var line: Line
    private lateinit var lines: ArrayList<Line>
    private lateinit var data: LineChartData
    private lateinit var axisb: Axis
    private lateinit var axisl :Axis
    private lateinit var table: TableLayout
    private lateinit var stress: TextView
    private lateinit var date: TextView
    private lateinit var target: View


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        resultView = inflater.inflate(R.layout.fragment_results, container, false)
        playerApp = Player.getInstance()
        playerApp.player.stop()

        lineChart = resultView.findViewById(R.id.line_chart)
        table = resultView.findViewById(R.id.table)

        val gStringWriter: GStringWriter =  GStringWriter.getInstance()
        stringWriter = gStringWriter.stringWriter
        stringReader = StringReader(stringWriter.toString())
        csvIterator = CSVIterator(CSVReader(stringReader))
        value = arrayListOf()
        var i : Int = 1
        value += PointValue(0F, 0F)
        for(row in csvIterator){
            value += PointValue(i.toFloat(),row[1].toFloat())
            target = inflater.inflate(R.layout.table_row, null)
            stress = target.findViewById(R.id.stress)
            date  = target.findViewById(R.id.time)
            stress.text = row[1]
            date.text = row[0]
            table.addView(target)
            i++
        }
        axisBottom = arrayListOf()
        axisLeft = arrayListOf()
        for(l in LEVEL){
            axisBottom += AxisValue(l.toFloat())
        }
        for(s in STRESS){
            axisLeft += AxisValue(s.toFloat())
        }
        lines = arrayListOf()
        line = Line(value).setColor(Color.BLUE).setCubic(true).setFilled(true)
        lines += line
        data = LineChartData()
        data.lines = lines

        axisb = Axis()
        axisb.values = axisBottom
        axisb.textColor = Color.GRAY
        axisb.textSize = 7
        axisb.name = "Instances"

        axisl = Axis()
        axisl.values = axisLeft
        axisl.textColor =Color.GRAY
        axisl.textSize = 7
        axisl.name = "Stress Level"

        data.axisXBottom = axisb
        data.axisYLeft=axisl
        lineChart.lineChartData = data

        return resultView
    }

    companion object{
        val STRESS: Array<Int> = arrayOf(0,2,4,6,8,10,12,14,16)
        val LEVEL: Array<Int> =  arrayOf(0,2,4,6,8,10,12,14,16)
    }

}