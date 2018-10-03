package com.firebirdcss.api.simple_json_mapper.tests;

import com.firebirdcss.api.simple_json_mapper.SimpleJsonMapper;
import com.firebirdcss.api.simple_json_mapper.json.JsonObject;
import com.firebirdcss.api.simple_json_mapper.json.Value;
import com.firebirdcss.api.simple_json_mapper.util.JsonUtils;

public class Sandbox {
	private static String jsonString = "{\n" + 
			"  \"terms\": [],\n" + 
			"  \"results\": [\n" + 
			"    {\n" + 
			"      \"host_count\": 1,\n" + 
			"      \"alert_type\": \"watchlist.hit.feedsearch.binary\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"digsig_result\": \"Unsigned\",\n" + 
			"      \"observed_filename\": [\n" + 
			"        \"c:\\\\users\\\\yu.yamamoto\\\\desktop\\\\training_work\\\\qpqpdndnn.exe\"\n" + 
			"      ],\n" + 
			"      \"report_score\": 80,\n" + 
			"      \"watchlist_id\": \"fileofficehigh\",\n" + 
			"      \"feed_id\": 10,\n" + 
			"      \"created_time\": \"2018-10-01T18:51:13.325Z\",\n" + 
			"      \"report_ignored\": false,\n" + 
			"      \"ioc_type\": \"md5\",\n" + 
			"      \"watchlist_name\": \"fileofficehigh\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 54.0,\n" + 
			"      \"hostname\": \"WIN-GN31V4382SQ\",\n" + 
			"      \"feed_name\": \"iconmatching\",\n" + 
			"      \"_version_\": 1613150157098975232,\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"description\": \"File/Office High\",\n" + 
			"      \"link\": \"https://www.bit9.com/cbfeeds/iconmatching_feed.xhtml#file_office\",\n" + 
			"      \"md5\": \"55D4EF740D7C10D6A5E1BE9B69FB0E15\",\n" + 
			"      \"segment_id\": 1,\n" + 
			"      \"observed_filename_total_count\": 1,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"ioc_value\": \"55d4ef740d7c10d6a5e1be9b69fb0e15\",\n" + 
			"      \"os_type\": \"Windows\",\n" + 
			"      \"unique_id\": \"e1e07cfe-1ed7-4e0f-9eb5-fbe30629ddaf\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"host_count\": 1,\n" + 
			"      \"alert_type\": \"watchlist.hit.feedsearch.binary\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"digsig_result\": \"Unsigned\",\n" + 
			"      \"observed_filename\": [\n" + 
			"        \"c:\\\\users\\\\yu.yamamoto\\\\desktop\\\\training_work\\\\qpqpdndnn.exe\"\n" + 
			"      ],\n" + 
			"      \"report_score\": 80,\n" + 
			"      \"watchlist_id\": \"fileofficehigh\",\n" + 
			"      \"feed_id\": 10,\n" + 
			"      \"created_time\": \"2018-09-30T18:51:13.318Z\",\n" + 
			"      \"report_ignored\": false,\n" + 
			"      \"ioc_type\": \"md5\",\n" + 
			"      \"watchlist_name\": \"fileofficehigh\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 54.0,\n" + 
			"      \"hostname\": \"WIN-GN31V4382SQ\",\n" + 
			"      \"feed_name\": \"iconmatching\",\n" + 
			"      \"_version_\": 1613059560123138048,\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"description\": \"File/Office High\",\n" + 
			"      \"link\": \"https://www.bit9.com/cbfeeds/iconmatching_feed.xhtml#file_office\",\n" + 
			"      \"md5\": \"55D4EF740D7C10D6A5E1BE9B69FB0E15\",\n" + 
			"      \"segment_id\": 1,\n" + 
			"      \"observed_filename_total_count\": 1,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"ioc_value\": \"55d4ef740d7c10d6a5e1be9b69fb0e15\",\n" + 
			"      \"os_type\": \"Windows\",\n" + 
			"      \"unique_id\": \"1e6ea016-c9de-415a-a10b-3dc3a59003f7\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"host_count\": 1,\n" + 
			"      \"alert_type\": \"watchlist.hit.feedsearch.binary\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"digsig_result\": \"Unsigned\",\n" + 
			"      \"observed_filename\": [\n" + 
			"        \"c:\\\\users\\\\yu.yamamoto\\\\desktop\\\\training_work\\\\qpqpdndnn.exe\"\n" + 
			"      ],\n" + 
			"      \"report_score\": 80,\n" + 
			"      \"watchlist_id\": \"fileofficehigh\",\n" + 
			"      \"feed_id\": 10,\n" + 
			"      \"created_time\": \"2018-09-29T18:51:12.06Z\",\n" + 
			"      \"report_ignored\": false,\n" + 
			"      \"ioc_type\": \"md5\",\n" + 
			"      \"watchlist_name\": \"fileofficehigh\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 54.0,\n" + 
			"      \"hostname\": \"WIN-GN31V4382SQ\",\n" + 
			"      \"feed_name\": \"iconmatching\",\n" + 
			"      \"_version_\": 1612968961836580864,\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"description\": \"File/Office High\",\n" + 
			"      \"link\": \"https://www.bit9.com/cbfeeds/iconmatching_feed.xhtml#file_office\",\n" + 
			"      \"md5\": \"55D4EF740D7C10D6A5E1BE9B69FB0E15\",\n" + 
			"      \"segment_id\": 1,\n" + 
			"      \"observed_filename_total_count\": 1,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"ioc_value\": \"55d4ef740d7c10d6a5e1be9b69fb0e15\",\n" + 
			"      \"os_type\": \"Windows\",\n" + 
			"      \"unique_id\": \"52b2978b-2686-4251-9d69-71fce5af4142\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"host_count\": 1,\n" + 
			"      \"alert_type\": \"watchlist.hit.feedsearch.binary\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"digsig_result\": \"Unsigned\",\n" + 
			"      \"observed_filename\": [\n" + 
			"        \"c:\\\\users\\\\yu.yamamoto\\\\desktop\\\\training_work\\\\qpqpdndnn.exe\"\n" + 
			"      ],\n" + 
			"      \"report_score\": 80,\n" + 
			"      \"watchlist_id\": \"fileofficehigh\",\n" + 
			"      \"feed_id\": 10,\n" + 
			"      \"created_time\": \"2018-09-28T18:51:11.782Z\",\n" + 
			"      \"report_ignored\": false,\n" + 
			"      \"ioc_type\": \"md5\",\n" + 
			"      \"watchlist_name\": \"fileofficehigh\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 54.0,\n" + 
			"      \"hostname\": \"WIN-GN31V4382SQ\",\n" + 
			"      \"feed_name\": \"iconmatching\",\n" + 
			"      \"_version_\": 1612878364580773888,\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"description\": \"File/Office High\",\n" + 
			"      \"link\": \"https://www.bit9.com/cbfeeds/iconmatching_feed.xhtml#file_office\",\n" + 
			"      \"md5\": \"55D4EF740D7C10D6A5E1BE9B69FB0E15\",\n" + 
			"      \"segment_id\": 1,\n" + 
			"      \"observed_filename_total_count\": 1,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"ioc_value\": \"55d4ef740d7c10d6a5e1be9b69fb0e15\",\n" + 
			"      \"os_type\": \"Windows\",\n" + 
			"      \"unique_id\": \"adcf8c06-282a-4909-8d77-81db91da6f03\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"username\": \"CT-SOC\\\\k.mino\",\n" + 
			"      \"alert_type\": \"watchlist.hit.ingress.process\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"modload_count\": 31,\n" + 
			"      \"report_score\": 80,\n" + 
			"      \"watchlist_id\": \"eeb25923-cb9b-4882-9332-a8373f13e2b4\",\n" + 
			"      \"sensor_id\": 21,\n" + 
			"      \"feed_name\": \"bit9suspiciousindicators\",\n" + 
			"      \"created_time\": \"2018-09-28T00:30:16.424Z\",\n" + 
			"      \"report_ignored\": false,\n" + 
			"      \"ioc_type\": \"query\",\n" + 
			"      \"watchlist_name\": \"eeb25923-cb9b-4882-9332-a8373f13e2b4\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 54.0,\n" + 
			"      \"crossproc_count\": 0,\n" + 
			"      \"group\": \"default group\",\n" + 
			"      \"hostname\": \"ep-test1\",\n" + 
			"      \"filemod_count\": 0,\n" + 
			"      \"comms_ip\": \"10.1.22.129\",\n" + 
			"      \"netconn_count\": 0,\n" + 
			"      \"interface_ip\": \"10.1.22.129\",\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"process_path\": \"c:\\\\windows\\\\system32\\\\svchost.exe\",\n" + 
			"      \"description\": \"Suspicious svchost user\",\n" + 
			"      \"process_name\": \"svchost.exe\",\n" + 
			"      \"process_unique_id\": \"00000015-0000-13f8-01d4-56c05fb9406e-01661d954f5c\",\n" + 
			"      \"process_id\": \"00000015-0000-13f8-01d4-56c05fb9406e\",\n" + 
			"      \"link\": \"https://www.carbonblack.com/cbfeeds/suspicious_feed.xhtml#21\",\n" + 
			"      \"_version_\": 1612809100530286592,\n" + 
			"      \"regmod_count\": 1,\n" + 
			"      \"md5\": \"32569e403279b3fd2edb7ebd036273fa\",\n" + 
			"      \"segment_id\": 496324444,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"feed_id\": 15,\n" + 
			"      \"ioc_value\": \"{\\\"index_type\\\": \\\"events\\\", \\\"search_query\\\": \\\"cb.urlver=1&q=process_name%3Asvchost.exe%20-username%3ASYSTEM%20-username%3A%22NETWORK%20SERVICE%22%20-username%3A%22LOCAL%20SERVICE%22%20-cmdline%3A%22UnistackSvcGroup%22)\\\"}\",\n" + 
			"      \"os_type\": \"windows\",\n" + 
			"      \"childproc_count\": 0,\n" + 
			"      \"unique_id\": \"18b42a03-1f67-4b00-bc3c-1a6613aaa027\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"username\": \"SYSTEM\",\n" + 
			"      \"alert_type\": \"watchlist.hit.query.process\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"modload_count\": 118,\n" + 
			"      \"report_score\": 75,\n" + 
			"      \"watchlist_id\": \"301\",\n" + 
			"      \"sensor_id\": 21,\n" + 
			"      \"feed_name\": \"My Watchlists\",\n" + 
			"      \"created_time\": \"2018-09-27T23:50:25.787Z\",\n" + 
			"      \"ioc_type\": \"query\",\n" + 
			"      \"watchlist_name\": \"file_create\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"ioc_attr\": \"{\\\"highlights\\\": [\\\"PREPREPREc:\\\\\\\\windows\\\\\\\\system32\\\\\\\\logfiles\\\\\\\\wmi\\\\\\\\rtbackup\\\\\\\\etwrtdiagtrack-listener.etlPOSTPOSTPOST\\\", \\\"PREPREPREc:\\\\\\\\windows\\\\\\\\system32\\\\\\\\logfiles\\\\\\\\wmi\\\\\\\\rtbackup\\\\\\\\etwrtdiagtrack-listener.etlPOSTPOSTPOST\\\"]}\",\n" + 
			"      \"alert_severity\": 50.625,\n" + 
			"      \"crossproc_count\": 0,\n" + 
			"      \"group\": \"default group\",\n" + 
			"      \"hostname\": \"ep-test1\",\n" + 
			"      \"filemod_count\": 29,\n" + 
			"      \"comms_ip\": \"10.1.22.129\",\n" + 
			"      \"netconn_count\": 0,\n" + 
			"      \"interface_ip\": \"10.1.22.129\",\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"process_path\": \"c:\\\\windows\\\\system32\\\\ntoskrnl.exe\",\n" + 
			"      \"process_name\": \"ntoskrnl.exe\",\n" + 
			"      \"process_unique_id\": \"00000015-0000-0004-01d4-56bb6f614f4a-01661d6810a0\",\n" + 
			"      \"process_id\": \"00000015-0000-0004-01d4-56bb6f614f4a\",\n" + 
			"      \"_version_\": 1612806593757315073,\n" + 
			"      \"regmod_count\": 751,\n" + 
			"      \"md5\": \"258919dd1f64c5c6fc15ff6326962281\",\n" + 
			"      \"segment_id\": 493359264,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"feed_id\": -1,\n" + 
			"      \"os_type\": \"windows\",\n" + 
			"      \"childproc_count\": 1,\n" + 
			"      \"unique_id\": \"efedeafc-91e3-4617-bed2-60d645fce3af\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"username\": \"SYSTEM\",\n" + 
			"      \"alert_type\": \"watchlist.hit.query.process\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"modload_count\": 118,\n" + 
			"      \"report_score\": 75,\n" + 
			"      \"watchlist_id\": \"299\",\n" + 
			"      \"sensor_id\": 21,\n" + 
			"      \"feed_name\": \"My Watchlists\",\n" + 
			"      \"created_time\": \"2018-09-27T23:50:25.783Z\",\n" + 
			"      \"ioc_type\": \"query\",\n" + 
			"      \"watchlist_name\": \"CB access\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 50.625,\n" + 
			"      \"crossproc_count\": 0,\n" + 
			"      \"group\": \"default group\",\n" + 
			"      \"hostname\": \"ep-test1\",\n" + 
			"      \"filemod_count\": 30,\n" + 
			"      \"comms_ip\": \"10.1.22.129\",\n" + 
			"      \"netconn_count\": 16,\n" + 
			"      \"interface_ip\": \"10.1.22.129\",\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"process_path\": \"c:\\\\windows\\\\system32\\\\ntoskrnl.exe\",\n" + 
			"      \"process_name\": \"ntoskrnl.exe\",\n" + 
			"      \"process_unique_id\": \"00000015-0000-0004-01d4-56bb6f614f4a-01661d6c9ee9\",\n" + 
			"      \"process_id\": \"00000015-0000-0004-01d4-56bb6f614f4a\",\n" + 
			"      \"_version_\": 1612806593757315072,\n" + 
			"      \"regmod_count\": 756,\n" + 
			"      \"md5\": \"258919dd1f64c5c6fc15ff6326962281\",\n" + 
			"      \"segment_id\": 493657833,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"feed_id\": -1,\n" + 
			"      \"os_type\": \"windows\",\n" + 
			"      \"childproc_count\": 1,\n" + 
			"      \"unique_id\": \"5753e2e3-7633-4a67-bf86-4bb13b693c15\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"username\": \"SYSTEM\",\n" + 
			"      \"alert_type\": \"watchlist.hit.query.process\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"modload_count\": 0,\n" + 
			"      \"report_score\": 75,\n" + 
			"      \"watchlist_id\": \"299\",\n" + 
			"      \"sensor_id\": 21,\n" + 
			"      \"feed_name\": \"My Watchlists\",\n" + 
			"      \"created_time\": \"2018-09-27T23:50:25.769Z\",\n" + 
			"      \"ioc_type\": \"query\",\n" + 
			"      \"watchlist_name\": \"CB access\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 50.625,\n" + 
			"      \"crossproc_count\": 0,\n" + 
			"      \"group\": \"default group\",\n" + 
			"      \"hostname\": \"ep-test1\",\n" + 
			"      \"filemod_count\": 0,\n" + 
			"      \"comms_ip\": \"10.1.22.129\",\n" + 
			"      \"netconn_count\": 2,\n" + 
			"      \"interface_ip\": \"10.1.22.129\",\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"process_path\": \"c:\\\\windows\\\\carbonblack\\\\cb.exe\",\n" + 
			"      \"process_name\": \"cb.exe\",\n" + 
			"      \"process_unique_id\": \"00000015-0000-1154-01d4-56bb761976fd-01661d6c9ee9\",\n" + 
			"      \"process_id\": \"00000015-0000-1154-01d4-56bb761976fd\",\n" + 
			"      \"_version_\": 1612806593755217920,\n" + 
			"      \"regmod_count\": 0,\n" + 
			"      \"md5\": \"e472001ffe350a80f4c1f3322180ca50\",\n" + 
			"      \"segment_id\": 493657833,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"feed_id\": -1,\n" + 
			"      \"os_type\": \"windows\",\n" + 
			"      \"childproc_count\": 0,\n" + 
			"      \"unique_id\": \"f008175c-7fa1-49a2-96ca-1e2527101537\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"host_count\": 1,\n" + 
			"      \"alert_type\": \"watchlist.hit.feedsearch.binary\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"digsig_result\": \"Unsigned\",\n" + 
			"      \"observed_filename\": [\n" + 
			"        \"c:\\\\users\\\\yu.yamamoto\\\\desktop\\\\training_work\\\\qpqpdndnn.exe\"\n" + 
			"      ],\n" + 
			"      \"report_score\": 80,\n" + 
			"      \"watchlist_id\": \"fileofficehigh\",\n" + 
			"      \"feed_id\": 10,\n" + 
			"      \"created_time\": \"2018-09-27T18:51:11.491Z\",\n" + 
			"      \"report_ignored\": false,\n" + 
			"      \"ioc_type\": \"md5\",\n" + 
			"      \"watchlist_name\": \"fileofficehigh\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 54.0,\n" + 
			"      \"hostname\": \"WIN-GN31V4382SQ\",\n" + 
			"      \"feed_name\": \"iconmatching\",\n" + 
			"      \"_version_\": 1612787767308189696,\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"description\": \"File/Office High\",\n" + 
			"      \"link\": \"https://www.bit9.com/cbfeeds/iconmatching_feed.xhtml#file_office\",\n" + 
			"      \"md5\": \"55D4EF740D7C10D6A5E1BE9B69FB0E15\",\n" + 
			"      \"segment_id\": 1,\n" + 
			"      \"observed_filename_total_count\": 1,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"ioc_value\": \"55d4ef740d7c10d6a5e1be9b69fb0e15\",\n" + 
			"      \"os_type\": \"Windows\",\n" + 
			"      \"unique_id\": \"a399c5d0-8ce5-48cd-a668-2ff23d6b4a4c\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"username\": \"SYSTEM\",\n" + 
			"      \"alert_type\": \"watchlist.hit.query.process\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"modload_count\": 99,\n" + 
			"      \"report_score\": 75,\n" + 
			"      \"watchlist_id\": \"301\",\n" + 
			"      \"sensor_id\": 41,\n" + 
			"      \"feed_name\": \"My Watchlists\",\n" + 
			"      \"created_time\": \"2018-09-27T01:20:24.886Z\",\n" + 
			"      \"ioc_type\": \"query\",\n" + 
			"      \"watchlist_name\": \"file_create\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"ioc_attr\": \"{\\\"highlights\\\": [\\\"PREPREPREc:\\\\\\\\windows\\\\\\\\system32\\\\\\\\logfiles\\\\\\\\wmi\\\\\\\\rtbackup\\\\\\\\etwrtdiagtrack-listener.etlPOSTPOSTPOST\\\", \\\"PREPREPREc:\\\\\\\\windows\\\\\\\\system32\\\\\\\\logfiles\\\\\\\\wmi\\\\\\\\rtbackup\\\\\\\\etwrtdiagtrack-listener.etlPOSTPOSTPOST\\\"]}\",\n" + 
			"      \"alert_severity\": 50.625,\n" + 
			"      \"crossproc_count\": 0,\n" + 
			"      \"group\": \"default group\",\n" + 
			"      \"hostname\": \"eptp-test\",\n" + 
			"      \"filemod_count\": 38,\n" + 
			"      \"comms_ip\": \"10.1.22.101\",\n" + 
			"      \"netconn_count\": 36,\n" + 
			"      \"interface_ip\": \"10.1.22.101\",\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"process_path\": \"C:\\\\windows\\\\system32\\\\ntoskrnl.exe\",\n" + 
			"      \"process_name\": \"ntoskrnl.exe\",\n" + 
			"      \"process_unique_id\": \"00000029-0000-0004-01d4-55f971d98f36-01661899fb7e\",\n" + 
			"      \"process_id\": \"00000029-0000-0004-01d4-55f971d98f36\",\n" + 
			"      \"_version_\": 1612721658158645248,\n" + 
			"      \"regmod_count\": 2053,\n" + 
			"      \"md5\": \"4085ceea9ea0eced65c8b306d49cf0c8\",\n" + 
			"      \"segment_id\": 412744574,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"feed_id\": -1,\n" + 
			"      \"os_type\": \"windows\",\n" + 
			"      \"childproc_count\": 1,\n" + 
			"      \"unique_id\": \"ebb57a00-b96a-433c-bdc8-e4c9f5ed60d4\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"username\": \"SYSTEM\",\n" + 
			"      \"alert_type\": \"watchlist.hit.query.process\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"modload_count\": 99,\n" + 
			"      \"report_score\": 75,\n" + 
			"      \"watchlist_id\": \"299\",\n" + 
			"      \"sensor_id\": 41,\n" + 
			"      \"feed_name\": \"My Watchlists\",\n" + 
			"      \"created_time\": \"2018-09-27T01:20:24.883Z\",\n" + 
			"      \"ioc_type\": \"query\",\n" + 
			"      \"watchlist_name\": \"CB access\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 50.625,\n" + 
			"      \"crossproc_count\": 0,\n" + 
			"      \"group\": \"default group\",\n" + 
			"      \"hostname\": \"eptp-test\",\n" + 
			"      \"filemod_count\": 38,\n" + 
			"      \"comms_ip\": \"10.1.22.101\",\n" + 
			"      \"netconn_count\": 36,\n" + 
			"      \"interface_ip\": \"10.1.22.101\",\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"process_path\": \"C:\\\\windows\\\\system32\\\\ntoskrnl.exe\",\n" + 
			"      \"process_name\": \"ntoskrnl.exe\",\n" + 
			"      \"process_unique_id\": \"00000029-0000-0004-01d4-55f971d98f36-01661899fb7e\",\n" + 
			"      \"process_id\": \"00000029-0000-0004-01d4-55f971d98f36\",\n" + 
			"      \"_version_\": 1612721658157596673,\n" + 
			"      \"regmod_count\": 2053,\n" + 
			"      \"md5\": \"4085ceea9ea0eced65c8b306d49cf0c8\",\n" + 
			"      \"segment_id\": 412744574,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"feed_id\": -1,\n" + 
			"      \"os_type\": \"windows\",\n" + 
			"      \"childproc_count\": 1,\n" + 
			"      \"unique_id\": \"82cfe94a-eeda-4661-829b-ea18a38fec0c\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"username\": \"SYSTEM\",\n" + 
			"      \"alert_type\": \"watchlist.hit.query.process\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"modload_count\": 0,\n" + 
			"      \"report_score\": 75,\n" + 
			"      \"watchlist_id\": \"299\",\n" + 
			"      \"sensor_id\": 41,\n" + 
			"      \"feed_name\": \"My Watchlists\",\n" + 
			"      \"created_time\": \"2018-09-27T01:20:24.879Z\",\n" + 
			"      \"ioc_type\": \"query\",\n" + 
			"      \"watchlist_name\": \"CB access\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 50.625,\n" + 
			"      \"crossproc_count\": 0,\n" + 
			"      \"group\": \"default group\",\n" + 
			"      \"hostname\": \"eptp-test\",\n" + 
			"      \"filemod_count\": 0,\n" + 
			"      \"comms_ip\": \"10.1.22.101\",\n" + 
			"      \"netconn_count\": 4,\n" + 
			"      \"interface_ip\": \"10.1.22.101\",\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"process_path\": \"c:\\\\windows\\\\carbonblack\\\\cb.exe\",\n" + 
			"      \"process_name\": \"cb.exe\",\n" + 
			"      \"process_unique_id\": \"00000029-0000-07fc-01d4-55f978967a72-01661899fb7e\",\n" + 
			"      \"process_id\": \"00000029-0000-07fc-01d4-55f978967a72\",\n" + 
			"      \"_version_\": 1612721658157596672,\n" + 
			"      \"regmod_count\": 0,\n" + 
			"      \"md5\": \"293cd7543f5cede3bc4f876c5fbb7048\",\n" + 
			"      \"segment_id\": 412744574,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"feed_id\": -1,\n" + 
			"      \"os_type\": \"windows\",\n" + 
			"      \"childproc_count\": 0,\n" + 
			"      \"unique_id\": \"45066976-d18c-4de8-b0b7-647d95643ae9\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"username\": \"EPTP-TEST\\\\Taka\",\n" + 
			"      \"alert_type\": \"watchlist.hit.query.process\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"modload_count\": 102,\n" + 
			"      \"report_score\": 75,\n" + 
			"      \"watchlist_id\": \"299\",\n" + 
			"      \"sensor_id\": 41,\n" + 
			"      \"feed_name\": \"My Watchlists\",\n" + 
			"      \"created_time\": \"2018-09-27T01:20:24.867Z\",\n" + 
			"      \"ioc_type\": \"query\",\n" + 
			"      \"watchlist_name\": \"CB access\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 50.625,\n" + 
			"      \"crossproc_count\": 6,\n" + 
			"      \"group\": \"default group\",\n" + 
			"      \"hostname\": \"eptp-test\",\n" + 
			"      \"filemod_count\": 1336,\n" + 
			"      \"comms_ip\": \"10.1.22.101\",\n" + 
			"      \"netconn_count\": 68,\n" + 
			"      \"interface_ip\": \"10.1.22.101\",\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"process_path\": \"c:\\\\program files (x86)\\\\google\\\\chrome\\\\application\\\\chrome.exe\",\n" + 
			"      \"process_name\": \"chrome.exe\",\n" + 
			"      \"process_unique_id\": \"00000029-0000-0d64-01d4-55feed708096-01661899fb7e\",\n" + 
			"      \"process_id\": \"00000029-0000-0d64-01d4-55feed708096\",\n" + 
			"      \"_version_\": 1612721658155499520,\n" + 
			"      \"regmod_count\": 20,\n" + 
			"      \"md5\": \"f8ba54ad76c8f8ec9f3d639871b30f27\",\n" + 
			"      \"segment_id\": 412744574,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"feed_id\": -1,\n" + 
			"      \"os_type\": \"windows\",\n" + 
			"      \"childproc_count\": 46,\n" + 
			"      \"unique_id\": \"7b581528-8388-48b1-8049-0a522a916743\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"username\": \"EPTP-TEST\\\\Taka\",\n" + 
			"      \"alert_type\": \"watchlist.hit.ingress.process\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"modload_count\": 1,\n" + 
			"      \"report_score\": 80,\n" + 
			"      \"watchlist_id\": \"c58dcfb8-e5ab-4766-a431-932cf6e93008\",\n" + 
			"      \"sensor_id\": 41,\n" + 
			"      \"feed_name\": \"bit9suspiciousindicators\",\n" + 
			"      \"created_time\": \"2018-09-27T01:20:16.477Z\",\n" + 
			"      \"report_ignored\": false,\n" + 
			"      \"ioc_type\": \"query\",\n" + 
			"      \"watchlist_name\": \"c58dcfb8-e5ab-4766-a431-932cf6e93008\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 54.0,\n" + 
			"      \"crossproc_count\": 1,\n" + 
			"      \"group\": \"default group\",\n" + 
			"      \"hostname\": \"eptp-test\",\n" + 
			"      \"filemod_count\": 2,\n" + 
			"      \"comms_ip\": \"10.1.22.101\",\n" + 
			"      \"netconn_count\": 0,\n" + 
			"      \"interface_ip\": \"10.1.22.101\",\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"process_path\": \"c:\\\\windows\\\\system32\\\\bcdedit.exe\",\n" + 
			"      \"description\": \"BCDEdit or BCDBoot Use\",\n" + 
			"      \"process_name\": \"bcdedit.exe\",\n" + 
			"      \"process_unique_id\": \"00000029-0000-1764-01d4-55f983572635-0166189cba32\",\n" + 
			"      \"process_id\": \"00000029-0000-1764-01d4-55f983572635\",\n" + 
			"      \"link\": \"https://securelist.com/blog/incidents/29593/an-unlikely-couple-64-bit-rootkit-and-rogue-av-for-macos/\",\n" + 
			"      \"_version_\": 1612721649344315392,\n" + 
			"      \"regmod_count\": 3,\n" + 
			"      \"md5\": \"67a57a47eb806e1064a81a9b2291bd7a\",\n" + 
			"      \"segment_id\": 412924466,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"feed_id\": 15,\n" + 
			"      \"ioc_value\": \"{\\\"index_type\\\": \\\"events\\\", \\\"search_query\\\": \\\"cb.urlver=1&q=(process_name%3Abcdboot.exe%20or%20process_name%3Abcdedit.exe)\\\"}\",\n" + 
			"      \"os_type\": \"windows\",\n" + 
			"      \"childproc_count\": 0,\n" + 
			"      \"unique_id\": \"5ecfc489-ed14-46c4-ab31-f2c056181e19\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"username\": \"EPTP-TEST\\\\Taka\",\n" + 
			"      \"alert_type\": \"watchlist.hit.ingress.process\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"modload_count\": 1,\n" + 
			"      \"report_score\": 80,\n" + 
			"      \"watchlist_id\": \"c58dcfb8-e5ab-4766-a431-932cf6e93008\",\n" + 
			"      \"sensor_id\": 41,\n" + 
			"      \"feed_name\": \"bit9suspiciousindicators\",\n" + 
			"      \"created_time\": \"2018-09-27T01:20:16.43Z\",\n" + 
			"      \"report_ignored\": false,\n" + 
			"      \"ioc_type\": \"query\",\n" + 
			"      \"watchlist_name\": \"c58dcfb8-e5ab-4766-a431-932cf6e93008\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 54.0,\n" + 
			"      \"crossproc_count\": 1,\n" + 
			"      \"group\": \"default group\",\n" + 
			"      \"hostname\": \"eptp-test\",\n" + 
			"      \"filemod_count\": 2,\n" + 
			"      \"comms_ip\": \"10.1.22.101\",\n" + 
			"      \"netconn_count\": 0,\n" + 
			"      \"interface_ip\": \"10.1.22.101\",\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"process_path\": \"c:\\\\windows\\\\system32\\\\bcdedit.exe\",\n" + 
			"      \"description\": \"BCDEdit or BCDBoot Use\",\n" + 
			"      \"process_name\": \"bcdedit.exe\",\n" + 
			"      \"process_unique_id\": \"00000029-0000-17b8-01d4-55f983976b5d-0166189cba18\",\n" + 
			"      \"process_id\": \"00000029-0000-17b8-01d4-55f983976b5d\",\n" + 
			"      \"link\": \"https://securelist.com/blog/incidents/29593/an-unlikely-couple-64-bit-rootkit-and-rogue-av-for-macos/\",\n" + 
			"      \"_version_\": 1612721649343266816,\n" + 
			"      \"regmod_count\": 2,\n" + 
			"      \"md5\": \"67a57a47eb806e1064a81a9b2291bd7a\",\n" + 
			"      \"segment_id\": 412924440,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"feed_id\": 15,\n" + 
			"      \"ioc_value\": \"{\\\"index_type\\\": \\\"events\\\", \\\"search_query\\\": \\\"cb.urlver=1&q=(process_name%3Abcdboot.exe%20or%20process_name%3Abcdedit.exe)\\\"}\",\n" + 
			"      \"os_type\": \"windows\",\n" + 
			"      \"childproc_count\": 0,\n" + 
			"      \"unique_id\": \"a0a50d20-cdbf-46ff-8be3-bc7b1f0132cc\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"host_count\": 1,\n" + 
			"      \"alert_type\": \"watchlist.hit.feedsearch.binary\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"digsig_result\": \"Unsigned\",\n" + 
			"      \"observed_filename\": [\n" + 
			"        \"c:\\\\users\\\\yu.yamamoto\\\\desktop\\\\training_work\\\\qpqpdndnn.exe\"\n" + 
			"      ],\n" + 
			"      \"report_score\": 80,\n" + 
			"      \"watchlist_id\": \"fileofficehigh\",\n" + 
			"      \"feed_id\": 10,\n" + 
			"      \"created_time\": \"2018-09-26T18:51:21.23Z\",\n" + 
			"      \"report_ignored\": false,\n" + 
			"      \"ioc_type\": \"md5\",\n" + 
			"      \"watchlist_name\": \"fileofficehigh\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 54.0,\n" + 
			"      \"hostname\": \"WIN-GN31V4382SQ\",\n" + 
			"      \"feed_name\": \"iconmatching\",\n" + 
			"      \"_version_\": 1612697180553871360,\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"description\": \"File/Office High\",\n" + 
			"      \"link\": \"https://www.bit9.com/cbfeeds/iconmatching_feed.xhtml#file_office\",\n" + 
			"      \"md5\": \"55D4EF740D7C10D6A5E1BE9B69FB0E15\",\n" + 
			"      \"segment_id\": 1,\n" + 
			"      \"observed_filename_total_count\": 1,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"ioc_value\": \"55d4ef740d7c10d6a5e1be9b69fb0e15\",\n" + 
			"      \"os_type\": \"Windows\",\n" + 
			"      \"unique_id\": \"181b968f-0a12-448c-9bb8-e27c65343533\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"username\": \"EPTP-TEST\\\\Taka\",\n" + 
			"      \"alert_type\": \"watchlist.hit.query.process\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"modload_count\": 99,\n" + 
			"      \"report_score\": 75,\n" + 
			"      \"watchlist_id\": \"299\",\n" + 
			"      \"sensor_id\": 41,\n" + 
			"      \"feed_name\": \"My Watchlists\",\n" + 
			"      \"created_time\": \"2018-09-26T01:20:27.328Z\",\n" + 
			"      \"ioc_type\": \"query\",\n" + 
			"      \"watchlist_name\": \"CB access\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 50.625,\n" + 
			"      \"crossproc_count\": 7,\n" + 
			"      \"group\": \"default group\",\n" + 
			"      \"hostname\": \"eptp-test\",\n" + 
			"      \"filemod_count\": 280,\n" + 
			"      \"comms_ip\": \"10.1.22.101\",\n" + 
			"      \"netconn_count\": 42,\n" + 
			"      \"interface_ip\": \"10.1.22.101\",\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"process_path\": \"c:\\\\program files (x86)\\\\google\\\\chrome\\\\application\\\\chrome.exe\",\n" + 
			"      \"process_name\": \"chrome.exe\",\n" + 
			"      \"process_unique_id\": \"00000029-0000-158c-01d4-55363af08631-0166137088f6\",\n" + 
			"      \"process_id\": \"00000029-0000-158c-01d4-55363af08631\",\n" + 
			"      \"_version_\": 1612631063778033664,\n" + 
			"      \"regmod_count\": 60,\n" + 
			"      \"md5\": \"f8ba54ad76c8f8ec9f3d639871b30f27\",\n" + 
			"      \"segment_id\": 326142198,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"feed_id\": -1,\n" + 
			"      \"os_type\": \"windows\",\n" + 
			"      \"childproc_count\": 31,\n" + 
			"      \"unique_id\": \"6136b789-af70-410d-9cdc-d4fa969d2029\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"username\": \"EPTP-TEST\\\\Taka\",\n" + 
			"      \"alert_type\": \"watchlist.hit.ingress.process\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"modload_count\": 1,\n" + 
			"      \"report_score\": 80,\n" + 
			"      \"watchlist_id\": \"c58dcfb8-e5ab-4766-a431-932cf6e93008\",\n" + 
			"      \"sensor_id\": 41,\n" + 
			"      \"feed_name\": \"bit9suspiciousindicators\",\n" + 
			"      \"created_time\": \"2018-09-26T01:20:19.17Z\",\n" + 
			"      \"report_ignored\": false,\n" + 
			"      \"ioc_type\": \"query\",\n" + 
			"      \"watchlist_name\": \"c58dcfb8-e5ab-4766-a431-932cf6e93008\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 54.0,\n" + 
			"      \"crossproc_count\": 1,\n" + 
			"      \"group\": \"default group\",\n" + 
			"      \"hostname\": \"eptp-test\",\n" + 
			"      \"filemod_count\": 2,\n" + 
			"      \"comms_ip\": \"10.1.22.101\",\n" + 
			"      \"netconn_count\": 0,\n" + 
			"      \"interface_ip\": \"10.1.22.101\",\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"process_path\": \"c:\\\\windows\\\\system32\\\\bcdedit.exe\",\n" + 
			"      \"description\": \"BCDEdit or BCDBoot Use\",\n" + 
			"      \"process_name\": \"bcdedit.exe\",\n" + 
			"      \"process_unique_id\": \"00000029-0000-1950-01d4-55363d2702ef-0166137668d9\",\n" + 
			"      \"process_id\": \"00000029-0000-1950-01d4-55363d2702ef\",\n" + 
			"      \"link\": \"https://securelist.com/blog/incidents/29593/an-unlikely-couple-64-bit-rootkit-and-rogue-av-for-macos/\",\n" + 
			"      \"_version_\": 1612631055201730560,\n" + 
			"      \"regmod_count\": 3,\n" + 
			"      \"md5\": \"67a57a47eb806e1064a81a9b2291bd7a\",\n" + 
			"      \"segment_id\": 326527193,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"feed_id\": 15,\n" + 
			"      \"ioc_value\": \"{\\\"index_type\\\": \\\"events\\\", \\\"search_query\\\": \\\"cb.urlver=1&q=(process_name%3Abcdboot.exe%20or%20process_name%3Abcdedit.exe)\\\"}\",\n" + 
			"      \"os_type\": \"windows\",\n" + 
			"      \"childproc_count\": 0,\n" + 
			"      \"unique_id\": \"bd9fbc4b-8483-4acf-9cfb-056bbc85b384\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"username\": \"EPTP-TEST\\\\Taka\",\n" + 
			"      \"alert_type\": \"watchlist.hit.ingress.process\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"modload_count\": 1,\n" + 
			"      \"report_score\": 80,\n" + 
			"      \"watchlist_id\": \"c58dcfb8-e5ab-4766-a431-932cf6e93008\",\n" + 
			"      \"sensor_id\": 41,\n" + 
			"      \"feed_name\": \"bit9suspiciousindicators\",\n" + 
			"      \"created_time\": \"2018-09-26T01:20:19.142Z\",\n" + 
			"      \"report_ignored\": false,\n" + 
			"      \"ioc_type\": \"query\",\n" + 
			"      \"watchlist_name\": \"c58dcfb8-e5ab-4766-a431-932cf6e93008\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"alert_severity\": 54.0,\n" + 
			"      \"crossproc_count\": 1,\n" + 
			"      \"group\": \"default group\",\n" + 
			"      \"hostname\": \"eptp-test\",\n" + 
			"      \"filemod_count\": 2,\n" + 
			"      \"comms_ip\": \"10.1.22.101\",\n" + 
			"      \"netconn_count\": 0,\n" + 
			"      \"interface_ip\": \"10.1.22.101\",\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"process_path\": \"c:\\\\windows\\\\system32\\\\bcdedit.exe\",\n" + 
			"      \"description\": \"BCDEdit or BCDBoot Use\",\n" + 
			"      \"process_name\": \"bcdedit.exe\",\n" + 
			"      \"process_unique_id\": \"00000029-0000-1974-01d4-55363d342280-0166137668c0\",\n" + 
			"      \"process_id\": \"00000029-0000-1974-01d4-55363d342280\",\n" + 
			"      \"link\": \"https://securelist.com/blog/incidents/29593/an-unlikely-couple-64-bit-rootkit-and-rogue-av-for-macos/\",\n" + 
			"      \"_version_\": 1612631055200681984,\n" + 
			"      \"regmod_count\": 2,\n" + 
			"      \"md5\": \"67a57a47eb806e1064a81a9b2291bd7a\",\n" + 
			"      \"segment_id\": 326527168,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"feed_id\": 15,\n" + 
			"      \"ioc_value\": \"{\\\"index_type\\\": \\\"events\\\", \\\"search_query\\\": \\\"cb.urlver=1&q=(process_name%3Abcdboot.exe%20or%20process_name%3Abcdedit.exe)\\\"}\",\n" + 
			"      \"os_type\": \"windows\",\n" + 
			"      \"childproc_count\": 0,\n" + 
			"      \"unique_id\": \"04321fdc-b762-43b6-9322-4acf0db0badb\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    },\n" + 
			"    {\n" + 
			"      \"username\": \"SYSTEM\",\n" + 
			"      \"alert_type\": \"watchlist.hit.query.process\",\n" + 
			"      \"sensor_criticality\": 3.0,\n" + 
			"      \"modload_count\": 97,\n" + 
			"      \"report_score\": 75,\n" + 
			"      \"watchlist_id\": \"301\",\n" + 
			"      \"sensor_id\": 41,\n" + 
			"      \"feed_name\": \"My Watchlists\",\n" + 
			"      \"created_time\": \"2018-09-26T01:00:28.644Z\",\n" + 
			"      \"ioc_type\": \"query\",\n" + 
			"      \"watchlist_name\": \"file_create\",\n" + 
			"      \"ioc_confidence\": 0.5,\n" + 
			"      \"ioc_attr\": \"{\\\"highlights\\\": [\\\"PREPREPREc:\\\\\\\\windows\\\\\\\\system32\\\\\\\\logfiles\\\\\\\\wmi\\\\\\\\rtbackup\\\\\\\\etwrtdiagtrack-listener.etlPOSTPOSTPOST\\\"]}\",\n" + 
			"      \"alert_severity\": 50.625,\n" + 
			"      \"crossproc_count\": 0,\n" + 
			"      \"group\": \"default group\",\n" + 
			"      \"hostname\": \"eptp-test\",\n" + 
			"      \"filemod_count\": 32,\n" + 
			"      \"comms_ip\": \"10.1.22.101\",\n" + 
			"      \"netconn_count\": 16,\n" + 
			"      \"interface_ip\": \"10.1.22.101\",\n" + 
			"      \"status\": \"Unresolved\",\n" + 
			"      \"process_path\": \"C:\\\\windows\\\\system32\\\\ntoskrnl.exe\",\n" + 
			"      \"process_name\": \"ntoskrnl.exe\",\n" + 
			"      \"process_unique_id\": \"00000029-0000-0004-01d4-5532ef22dc59-0166135a3d9e\",\n" + 
			"      \"process_id\": \"00000029-0000-0004-01d4-5532ef22dc59\",\n" + 
			"      \"_version_\": 1612629806840545281,\n" + 
			"      \"regmod_count\": 2013,\n" + 
			"      \"md5\": \"4085ceea9ea0eced65c8b306d49cf0c8\",\n" + 
			"      \"segment_id\": 324681118,\n" + 
			"      \"total_hosts\": \"0\",\n" + 
			"      \"feed_id\": -1,\n" + 
			"      \"os_type\": \"windows\",\n" + 
			"      \"childproc_count\": 1,\n" + 
			"      \"unique_id\": \"45e76ef9-db98-4b7a-8281-7bfd52aaebf4\",\n" + 
			"      \"feed_rating\": 3.0\n" + 
			"    }\n" + 
			"  ],\n" + 
			"  \"elapsed\": 0.0094468593597412109,\n" + 
			"  \"comprehensive_search\": true,\n" + 
			"  \"all_segments\": true,\n" + 
			"  \"total_results\": 6747,\n" + 
			"  \"highlights\": [],\n" + 
			"  \"facets\": {},\n" + 
			"  \"start\": 0,\n" + 
			"  \"incomplete_results\": false,\n" + 
			"  \"filtered\": {}\n" + 
			"}";
	
	public static void main(String[] args) {
		System.out.println("The Map:");
		System.out.println(JsonUtils.mapJson(jsonString) + "\n");
		
		SimpleJsonMapper sjm = new SimpleJsonMapper(jsonString);
		
		System.out.println("The results[4] object:");
		System.out.println(sjm.getValue("results[4]").toString());
		
		Value v = sjm.getValue("results[4]");
		JsonObject jo = v.getAsJsonObject();
		System.out.println("\nProcess Path: " + jo.getValue("process_path"));
	}

}
