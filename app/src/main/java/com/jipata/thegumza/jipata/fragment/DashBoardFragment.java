package com.jipata.thegumza.jipata.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.DefaultYAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.jipata.thegumza.jipata.R;
import com.jipata.thegumza.jipata.adapter.RubberPagerAdapter;
import com.jipata.thegumza.jipata.model.DailyRubber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class DashBoardFragment extends Fragment {

    LineChart mChart, mChart2, mChart3, mChart4;
    Typeface typeface;
    List<DailyRubber> rubberList;

    public DashBoardFragment() {
        super();
    }

    public static DashBoardFragment newInstance() {
        DashBoardFragment fragment = new DashBoardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initInstances(rootView, savedInstanceState);
        initChartData(mChart);
        initChartData(mChart2);
        initChartData(mChart3);
        initChartData(mChart4);
        return rootView;
    }

    @SuppressWarnings("UnusedParameters")
    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
        rubberList = new ArrayList<>();
        DailyRubber dailyRubber = new DailyRubber();
        dailyRubber.setDataDate("17 ส.ค.");
        dailyRubber.setLocalPrice("51.60");
        rubberList.add(dailyRubber);
        DailyRubber dailyRubber2 = new DailyRubber();
        dailyRubber2.setDataDate("16 ส.ค.");
        dailyRubber2.setLocalPrice("51.60");
        rubberList.add(dailyRubber2);
        DailyRubber dailyRubber3 = new DailyRubber();
        dailyRubber3.setDataDate("15 ส.ค.");
        dailyRubber3.setLocalPrice("52.10");
        rubberList.add(dailyRubber3);
        DailyRubber dailyRubber4 = new DailyRubber();
        dailyRubber4.setDataDate("14 ส.ค.");
        dailyRubber4.setLocalPrice("51.60");
        rubberList.add(dailyRubber4);
        DailyRubber dailyRubber5 = new DailyRubber();
        dailyRubber5.setDataDate("13 ส.ค.");
        dailyRubber5.setLocalPrice("52.10");
        rubberList.add(dailyRubber5);
        DailyRubber dailyRubber6 = new DailyRubber();
        dailyRubber6.setDataDate("12 ส.ค.");
        dailyRubber6.setLocalPrice("52.60");
        rubberList.add(dailyRubber6);
        Collections.reverse(rubberList);
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        // Note: State of variable initialized here could not be saved
        //       in onSavedInstanceState
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        mChart = (LineChart) rootView.findViewById(R.id.mChart);
        mChart2 = (LineChart) rootView.findViewById(R.id.mChart2);
        mChart3 = (LineChart) rootView.findViewById(R.id.mChart3);
        mChart4 = (LineChart) rootView.findViewById(R.id.mChart4);
    }

    private void initChartData(LineChart mChart) {

        Legend l = mChart.getLegend();
        l.setEnabled(false);
        XAxis xAxis = mChart.getXAxis();
        YAxis leftAxis = mChart.getAxisLeft();

        if (isAdded() && getActivity() != null) {
            typeface = Typeface.createFromAsset(getActivity().getAssets(), getActivity().getString(R.string.font));
            xAxis.setTypeface(typeface);
            leftAxis.setTypeface(typeface);
            xAxis.setTextColor(ContextCompat.getColor(getActivity(), R.color.textColor));
            xAxis.setAxisLineColor(ContextCompat.getColor(getActivity(), R.color.textColor));
            leftAxis.setTextColor(ContextCompat.getColor(getActivity(), R.color.textColor));
            leftAxis.setAxisLineColor(ContextCompat.getColor(getActivity(), R.color.textColor));
        }

        xAxis.setTextSize(10f);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelsToSkip(0);

        leftAxis.setDrawGridLines(false);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setLabelCount(4, true);
        leftAxis.setValueFormatter(new DefaultYAxisValueFormatter(2));
        leftAxis.setXOffset(10);

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setEnabled(false);

        mChart.setDrawGridBackground(false);
        mChart.setDescription("");
        mChart.setNoDataTextDescription("Not Available");
        mChart.setTouchEnabled(false);
        mChart.setDragEnabled(false);
        mChart.setScaleEnabled(false);
        mChart.setPinchZoom(false);
        mChart.setScaleEnabled(false);
        mChart.setExtraOffsets(0,0,0,10);

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < rubberList.size(); i++) {
            xVals.add(rubberList.get(i).getDataDate());
        }

        ArrayList<Entry> yVals = new ArrayList<Entry>();

        for (int i = 0; i < rubberList.size(); i++) {
            yVals.add(new Entry(Float.valueOf(rubberList.get(i).getLocalPrice()), i));
        }

        LineDataSet set1, set2, set3, set4;

        // create a dataset and give it a type
        set1 = new LineDataSet(yVals, "");

        // set the line to be drawn like this "- - - - - -"
        set1.setColor(ContextCompat.getColor(getActivity(), R.color.textColor));
        set1.setLineWidth(1.5f);
        set1.setDrawCircleHole(false);
        set1.setDrawFilled(true);
        set1.setFillColor(ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));
        set1.setDrawCircles(true);
        set1.setCircleColor(ContextCompat.getColor(getActivity(), R.color.textColor));
        set1.setDrawValues(true);
        set1.setValueTextSize(12f);
        set1.setValueTypeface(typeface);
        set1.setValueTextColor(ContextCompat.getColor(getActivity(), R.color.textColor));
        set1.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1); // add the datasets
        // create a data object with the datasets
        LineData data = new LineData(xVals, dataSets);
        // set data
        mChart.setData(data);
        mChart.animateX(500);
        mChart.moveViewToX(xVals.size());
        mChart.invalidate();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance (Fragment level's variables) State here
    }

    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance (Fragment level's variables) State here
    }

}
