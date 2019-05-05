package samuel.griffiths.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skill.*
import samuel.griffiths.swoosh.Model.Player
import samuel.griffiths.swoosh.R
import samuel.griffiths.swoosh.Utilities.EXTRA_PLAYER

class SkillActivity : BaseActivity() {

    lateinit var player : Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    fun onBeginnerClick(view: View){
        player.skill = "beginner"
        ballerSkillBtn.isChecked = false
    }

    fun onBallerClick(view: View){
        player.skill = "baller"
        beginnerSkillBtn.isChecked = false
    }

    fun onSkillFinichClick(view: View){
        if (player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        }else{
            Toast.makeText(this, "Please select a skill category.", Toast.LENGTH_SHORT).show()
        }
    }
}
