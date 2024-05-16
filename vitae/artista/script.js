

// Función para manejar la reproducción o pausa del audio asociado al ID dado
function toggleAudio(audioId) {
    const audioElement = document.getElementById(audioId);

    // Pausar todos los audios excepto el audio actual si está reproduciéndose
    const allAudioElements = document.getElementsByTagName('audio');
    for (let i = 0; i < allAudioElements.length; i++) {
        const currentAudio = allAudioElements[i];
        if (currentAudio.id !== audioId) {
            currentAudio.pause();
        }
    }

    // Verificar si el audio actual está reproduciéndose
    if (audioElement.paused) {
        // Si está pausado, reproducirlo
        audioElement.play();
    } else {
        // Si está reproduciéndose, pausarlo
        audioElement.pause();
    }
}

