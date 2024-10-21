package org.n27.nutshell.common.presentation.composables

import androidx.annotation.RawRes
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import org.n27.nutshell.common.presentation.extensions.playErrorAnimation

@Composable
fun Lottie(
    @RawRes res: Int,
    modifier: Modifier = Modifier,
    isError: Boolean = false
) {
    AndroidView(
        modifier = modifier.aspectRatio(1f),
        factory = { context ->
            LottieAnimationView(context).apply {
                setAnimation(res)

                if (isError) {
                    playErrorAnimation()
                } else {
                    repeatCount = LottieDrawable.INFINITE
                    playAnimation()
                }
            }
        }
    )
}
