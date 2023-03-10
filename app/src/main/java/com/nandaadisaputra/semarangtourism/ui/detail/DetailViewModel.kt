package com.nandaadisaputra.semarangtourism.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nandaadisaputra.semarangtourism.data.model.SemarangTourismModel
import com.nandaadisaputra.semarangtourism.data.repository.SemarangTourismRepository
import com.nandaadisaputra.semarangtourism.ui.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
private val semarangTourismRepository: SemarangTourismRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<SemarangTourismModel>> = MutableStateFlow(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun getTourismPlaceById(id: Int) = viewModelScope.launch {
        semarangTourismRepository .getTourismPlaceById(id)
            .catch {
                _uiState.value = UiState.Error(it.message.toString())
            }
            .collect {
                _uiState.value = UiState.Success(it)
            }
    }
}