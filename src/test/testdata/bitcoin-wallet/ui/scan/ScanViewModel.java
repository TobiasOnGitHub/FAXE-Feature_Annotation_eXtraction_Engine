/*
 * Copyright the original author or authors.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package de.schildbach.wallet.ui.scan;

import android.arch.lifecycle.ViewModel;
import de.schildbach.wallet.data.SingleLiveEvent;

/**
 * @author Andreas Schildbach
 */
public class ScanViewModel extends ViewModel {
    public final SingleLiveEvent<Void> showPermissionWarnDialog = new SingleLiveEvent<>();
    public final SingleLiveEvent<Void> showProblemWarnDialog = new SingleLiveEvent<>();
}