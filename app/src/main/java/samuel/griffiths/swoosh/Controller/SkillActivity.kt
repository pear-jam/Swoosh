package samuel.griffiths.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skill.*
import samuel.griffiths.swoosh.Utilities.EXTRA_LEAGUE
import samuel.griffiths.swoosh.R
import samuel.griffiths.swoosh.Utilities.EXTRA_SKILL

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        println(league)
    }

    fun onBeginnerClick(view: View){
        skill = "beginner"
        ballerSkillBtn.isChecked = false
    }

    fun onBallerClick(view: View){
        skill = "baller"
        beginnerSkillBtn.isChecked = false
    }

    fun onSkillFinichClick(view: View){
        if (skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        }else{
            Toast.makeText(this, "Please select a skill category.", Toast.LENGTH_SHORT).show()
        }
    }
}
