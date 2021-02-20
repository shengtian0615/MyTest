/**
 * Copyright (C) 2014-2015 5WeHealth Technologies. All rights reserved.
 *  
 *    @author: Jingtao Yun Dec 11, 2014
 */

package com.wehealth.model.domain.enumutil;

public enum ECGDataDiagnosisType { 
	auto,  // system diagnose automatically
	manual, // doctor diagnose
	uploaded,
	none,
	rescue,
    libang, //libang analyse
	nalong, // nalong analysis
	karola //康如来看图
}