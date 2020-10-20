package by.limitAlltheir.myapplication.database.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun launchIo(task: suspend () -> Unit) {
    CoroutineScope(Dispatchers.IO).launch {
        task()
    }
}

fun launchUi(task: suspend () -> Unit) {

    CoroutineScope(Dispatchers.Main).launch {
        task()
    }
}

suspend fun <R> launchForResult(task: suspend () -> R): R? {

    return withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
        task()
    }

}

