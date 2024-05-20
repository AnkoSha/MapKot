package com.example.mapkot

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.mapkit.map.PlacemarkMapObject
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider
import com.example.mapkot.R

class MainActivity : AppCompatActivity() {
    private lateinit var mapView: MapView

    private val placemarkTapListener = MapObjectTapListener { mapObject, point ->
        Toast.makeText(
            this@MainActivity,
            "${point.longitude}, ${point.latitude}",
            Toast.LENGTH_SHORT
        ).show()
        val correctUrl = getString(R.string.u_irs)
        val intent=Intent(this,QuizActivity2::class.java)
        val latitude = point.latitude
        val longitude = point.longitude
        val tolerance = 2.0

        if (latitude in (55.75 - tolerance)..(55.75 + tolerance) && longitude in (37.617698 - tolerance)..(37.617698 + tolerance)) {
        intent.putExtra("question", getString(R.string.q_msk))
        intent.putExtra("answerA", getString(R.string.a_msk))
        intent.putExtra("answerB", getString(R.string.b_msk))
        intent.putExtra("answerC", getString(R.string.c_msk))
        intent.putExtra("answerD", getString(R.string.d_msk))
        intent.putExtra("imageResource", R.drawable.msk)
        intent.putExtra("correctAnswer", R.string.a_msk)
            intent.putExtra("correctUrl", correctUrl)
            } else if (point.latitude in (52.289588 - tolerance)..(52.289588 + tolerance) && point.longitude in (104.280606 - tolerance)..(104.280606 + tolerance)){
            intent.putExtra("question", getString(R.string.q_irs))
            intent.putExtra("answerA", getString(R.string.a_irs))
            intent.putExtra("answerB", getString(R.string.b_irs))
            intent.putExtra("answerC", getString(R.string.c_irs))
            intent.putExtra("answerD", getString(R.string.d_irs))
            intent.putExtra("imageResource", R.drawable.irs)
            intent.putExtra("correctAnswer", R.string.c_irs)
            intent.putExtra("correctUrl", correctUrl)
            }
        else if (point.latitude in (59.938784 - tolerance)..(59.938784 + tolerance) && point.longitude in (30.314997 - tolerance)..(30.314997 + tolerance)){
            intent.putExtra("question", getString(R.string.q_spb))
            intent.putExtra("answerA", getString(R.string.a_spb))
            intent.putExtra("answerB", getString(R.string.b_spb))
            intent.putExtra("answerC", getString(R.string.c_spb))
            intent.putExtra("answerD", getString(R.string.d_spb))
            intent.putExtra("imageResource", R.drawable.spb)
            intent.putExtra("correctAnswer", R.string.c_spb)
            intent.putExtra("correctUrl", correctUrl)
        }
        else if (point.latitude in (56.010543 - tolerance)..(56.010543 + tolerance) && point.longitude in (92.852581 - tolerance)..(92.852581 + tolerance)){
            intent.putExtra("question", getString(R.string.q_krs))
            intent.putExtra("answerA", getString(R.string.a_krs))
            intent.putExtra("answerB", getString(R.string.b_krs))
            intent.putExtra("answerC", getString(R.string.c_krs))
            intent.putExtra("answerD", getString(R.string.d_krs))
            intent.putExtra("imageResource", R.drawable.krs)
            intent.putExtra("correctAnswer", R.string.c_krs)
            intent.putExtra("correctUrl", correctUrl)
        }
        else if (point.latitude in (43.115542 - tolerance)..(43.115542 + tolerance) && point.longitude in (131.885494 - tolerance)..(131.885494 + tolerance)){
            intent.putExtra("question", getString(R.string.q_vld))
            intent.putExtra("answerA", getString(R.string.a_vld))
            intent.putExtra("answerB", getString(R.string.b_vld))
            intent.putExtra("answerC", getString(R.string.c_vld))
            intent.putExtra("answerD", getString(R.string.d_vld))
            intent.putExtra("imageResource", R.drawable.vld)
            intent.putExtra("correctAnswer", R.string.c_vld)
            intent.putExtra("correctUrl", correctUrl)
        }
        else if (point.latitude in (46.957771 - tolerance)..(46.957771 + tolerance) || point.longitude in (142.729587 - tolerance)..(142.729587 + tolerance)){
            intent.putExtra("question", getString(R.string.q_us))
            intent.putExtra("answerA", getString(R.string.a_us))
            intent.putExtra("answerB", getString(R.string.b_us))
            intent.putExtra("answerC", getString(R.string.c_us))
            intent.putExtra("answerD", getString(R.string.d_us))
            intent.putExtra("imageResource", R.drawable.us)
            intent.putExtra("correctAnswer", R.string.c_us)
            intent.putExtra("correctUrl", correctUrl)
        }
        else if (point.latitude in (55.030204 - tolerance)..(55.030204 + tolerance) && point.longitude in (82.920430 - tolerance)..(82.920430 + tolerance)){
            intent.putExtra("question", getString(R.string.q_nsk))
            intent.putExtra("answerA", getString(R.string.a_nsk))
            intent.putExtra("answerB", getString(R.string.b_nsk))
            intent.putExtra("answerC", getString(R.string.c_nsk))
            intent.putExtra("answerD", getString(R.string.d_nsk))
            intent.putExtra("imageResource", R.drawable.nsk)
            intent.putExtra("correctAnswer", R.string.b_nsk)
            intent.putExtra("correctUrl", correctUrl)
        }
        startActivity(intent)
        true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        MapKitFactory.setApiKey("3cd1b7f6-28d4-4dad-b810-03edf6bb0904") // Your generated API key
        MapKitFactory.initialize(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mapView = findViewById(R.id.mapview)

        val mark_now: PlacemarkMapObject = mapView.map.mapObjects.addPlacemark(
            Point(55.030204, 82.920430),
            ImageProvider.fromResource(this, R.drawable.mark) // старое изображение при неправильном ответе

        )
        val mark_spb: PlacemarkMapObject = mapView.map.mapObjects.addPlacemark(
            Point(59.938784, 30.314997),
            ImageProvider.fromResource(this, R.drawable.mark)
        )
        val mark_msk: PlacemarkMapObject = mapView.map.mapObjects.addPlacemark(
            Point(55.755864, 37.617698),
            ImageProvider.fromResource(this, R.drawable.mark)
        )
        val mark_krs: PlacemarkMapObject = mapView.map.mapObjects.addPlacemark(
            Point(56.010543, 92.852581),
            ImageProvider.fromResource(this, R.drawable.mark)
        )
        val mark_irk: PlacemarkMapObject = mapView.map.mapObjects.addPlacemark(
            Point(52.289588, 104.280606),
            ImageProvider.fromResource(this, R.drawable.mark)
        )
        val mark_vl: PlacemarkMapObject = mapView.map.mapObjects.addPlacemark(
            Point(43.115542, 131.885494),
            ImageProvider.fromResource(this, R.drawable.mark)
        )
        val mark_us: PlacemarkMapObject = mapView.map.mapObjects.addPlacemark(
            Point(46.957771, 142.729587),
            ImageProvider.fromResource(this, R.drawable.mark)
        )

        mark_msk.addTapListener(placemarkTapListener)
        mark_irk.addTapListener(placemarkTapListener)
        mark_us.addTapListener(placemarkTapListener)
        mark_now.addTapListener(placemarkTapListener)
        mark_vl.addTapListener(placemarkTapListener)
        mark_krs.addTapListener(placemarkTapListener)
        mark_spb.addTapListener(placemarkTapListener)

    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}